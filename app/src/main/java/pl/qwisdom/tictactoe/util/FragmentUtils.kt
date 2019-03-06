package pl.qwisdom.tictactoe.util

import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import pl.qwisdom.tictactoe.R

/**
 * Open new fragment.
 *
 * @param fragment Fragment instance.
 * @param sfm Object of SupportFragmentManager. It's part of activity.
 *
 * Usage examples:
 * openFragment(PlayFragment.newInstance(),supportFragmentActivity).
 * openFragment(AccountFragment.newInstance(),activity?.supportFragmentActivity)
 *
 */
fun openFragment(fragment: Fragment, @Nullable sfm: FragmentManager) {
    val transaction = sfm.beginTransaction()
    transaction.replace(R.id.container, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}