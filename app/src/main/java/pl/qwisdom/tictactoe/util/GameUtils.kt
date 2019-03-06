package pl.qwisdom.tictactoe.util

import pl.qwisdom.tictactoe.model.Player

fun checkWinCondition(player: Player): Boolean {
    player.list.forEach {
        when (it) {
            1 -> if ((player.list.contains(2) && player.list.contains(3)) || (player.list.contains(4) && player.list.contains(7)) || (player.list.contains(5) && player.list.contains(9))) return true
            2 -> if ((player.list.contains(1) && player.list.contains(3)) || (player.list.contains(5) && player.list.contains(8))) return true
            3 -> if ((player.list.contains(1) && player.list.contains(2)) || (player.list.contains(6) && player.list.contains(9)) || (player.list.contains(5) && player.list.contains(7))) return true
            4 -> if ((player.list.contains(1) && player.list.contains(7)) || (player.list.contains(5) && player.list.contains(6))) return true
            5 -> if ((player.list.contains(2) && player.list.contains(8)) || (player.list.contains(4) && player.list.contains(6)) || (player.list.contains(1) && player.list.contains(9)) || (player.list.contains(3) && player.list.contains(7))) return true
            6 -> if ((player.list.contains(3) && player.list.contains(9)) || (player.list.contains(4) && player.list.contains(5))) return true
            7 -> if ((player.list.contains(1) && player.list.contains(4)) || (player.list.contains(8) && player.list.contains(9)) || (player.list.contains(3) && player.list.contains(5))) return true
            8 -> if ((player.list.contains(2) && player.list.contains(5)) || (player.list.contains(7) && player.list.contains(9))) return true
            9 -> if ((player.list.contains(3) && player.list.contains(6)) || (player.list.contains(7) && player.list.contains(8)) || (player.list.contains(1) && player.list.contains(5))) return true
        }
    }
    return false
}