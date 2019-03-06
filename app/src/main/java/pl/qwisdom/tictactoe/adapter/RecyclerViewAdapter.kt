package pl.qwisdom.tictactoe.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import pl.qwisdom.tictactoe.R
import pl.qwisdom.tictactoe.model.Room

class RecyclerViewAdapter(private val roomList: ArrayList<Room>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var roomId = itemView.room_id_tv
        var state = itemView.room_state_tv
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.recycler_view_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = roomList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val room = roomList[p1]
        p0.roomId.text = room.roomId
        p0.state.text = room.state
    }
}