package pl.qwisdom.tictactoe.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.add_room_dialog.view.*
import pl.qwisdom.tictactoe.R
import pl.qwisdom.tictactoe.adapter.RecyclerViewAdapter
import pl.qwisdom.tictactoe.model.Room

class RoomsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var db: FirebaseFirestore
    val DB_TAG = "FIRESTORE"
    private lateinit var rooms: ArrayList<Room>
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var dialogView: View
    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        rooms = ArrayList<Room>()
        db = FirebaseFirestore.getInstance()

        add_room_fab.setOnClickListener(this)

        db.collection("rooms")
            .get()
            .addOnCompleteListener {task ->
                when (task.isSuccessful) {
                    true -> {
                        task.result?.forEach {room ->
                            Log.d(DB_TAG, "${room.id} + ${room.data}")
                            rooms.add(Room(
                                roomId = room.data["roomID"] as String,
                                state = room.data["state"] as String
                            ))
                        }
                        room_rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                        adapter = RecyclerViewAdapter(rooms)
                        room_rv.adapter = adapter
                    }
                    else -> Log.d(DB_TAG, "Error getting documents.", task.exception)
                }
            }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add_room_fab -> {
                val builder = AlertDialog.Builder(this)
                dialogView = layoutInflater.inflate(R.layout.add_room_dialog, null, false)
                builder.setView(dialogView)
                dialog = builder.create()
                dialog.show()
            }
        }
    }

    fun onDialogClick(v: View?) {
        when (v?.id) {
            R.id.add_room_btn -> {
                val room = HashMap<String, Any>()
                room["roomID"] = dialogView.room_id_tiet.text.toString()
                room["password"] = dialogView.room_password_tiet.text.toString()
                room["state"] = "open"
                room["turn"] = 0
                db.collection("rooms")
                    .add(room)
                    .addOnCompleteListener {task ->
                        when (task.isSuccessful) {
                            true -> startActivity(Intent(this, GameActivity::class.java).putExtra("mode", 2))
                            else -> Log.d(DB_TAG, "Error while adding room.", task.exception)
                        }
                        dialog.dismiss()
                    }
            }
        }
    }
}
