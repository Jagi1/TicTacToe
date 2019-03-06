package pl.qwisdom.tictactoe.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game.*
import pl.qwisdom.tictactoe.R
import pl.qwisdom.tictactoe.model.Player
import pl.qwisdom.tictactoe.util.checkWinCondition

class GameActivity : AppCompatActivity(), View.OnClickListener {

    private var MODE_ID: Int = 0
    private val fields = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
    private var player = Player()
    private var enemy = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        MODE_ID = intent?.extras!!.getInt("mode")

        play_again_btn.setOnClickListener(this)
        exit_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.play_again_btn -> recreate()
            R.id.exit_btn -> finish()
        }
    }

    private fun update(view: ImageView, pID: Int, fID: Int) {
        fields.remove(fID)
        view.isClickable = false
        when (pID) {
            1 -> {
                view.setImageDrawable(getDrawable(R.drawable.polygon))
                player.list.add(fID)
                if (checkWinCondition(player)) {
                    play_again_btn.visibility = View.VISIBLE
                    exit_btn.visibility = View.VISIBLE
                }
                else chooseField()
            }
            2 -> {
                enemy.list.add(fID)
                view.setImageDrawable(getDrawable(R.drawable.circle))
                if (checkWinCondition(enemy)) {
                    play_again_btn.visibility = View.VISIBLE
                    exit_btn.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun chooseField() {
        val rng = fields.random()
        when (rng) {
            1 -> update(field1, 2, 1)
            2 -> update(field2, 2, 2)
            3 -> update(field3, 2, 3)
            4 -> update(field4, 2, 4)
            5 -> update(field5, 2, 5)
            6 -> update(field6, 2, 6)
            7 -> update(field7, 2, 7)
            8 -> update(field8, 2, 8)
            9 -> update(field9, 2, 9)
        }
    }

    fun field1Click(view: View) = update(view as ImageView, 1, 1)

    fun field2Click(view: View) = update(view as ImageView, 1, 2)

    fun field3Click(view: View) = update(view as ImageView, 1, 3)

    fun field4Click(view: View) = update(view as ImageView, 1, 4)

    fun field5Click(view: View) = update(view as ImageView, 1, 5)

    fun field6Click(view: View) = update(view as ImageView, 1, 6)

    fun field7Click(view: View) = update(view as ImageView, 1, 7)

    fun field8Click(view: View) = update(view as ImageView, 1, 8)

    fun field9Click(view: View) = update(view as ImageView, 1, 9)
}
