package pl.qwisdom.tictactoe.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pl.qwisdom.tictactoe.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSingle(view: View) = startActivity(Intent(this, GameActivity::class.java).putExtra("mode",1))

    fun startMulti(view: View) = startActivity(Intent(this, RoomsActivity::class.java))

    fun exitApp(view: View) = finish()
}
