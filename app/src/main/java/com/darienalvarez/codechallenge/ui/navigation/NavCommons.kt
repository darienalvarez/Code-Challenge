package com.darienalvarez.codechallenge.ui.navigation

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.R

/**
 * Commons method used for navigation
 */
interface NavCommons {

    val options: NavOptions

    /**
     * Go to a fragment using a [NavDirections] and the common animations options will be added
     *
     * @param fragment the fragment to get the nav graph
     * @param action the action to navigate
     */
    fun goToFragment(fragment: Fragment?, action: NavDirections)

    /**
     * use this variation when to origin is not in the same nav graph as destination
     *
     * @param view view of origin, used to find
     * @param action the action to navigate
     */
    fun goToFragment(view: View, action: NavDirections)

    /**
     * Go to a fragment using a [NavDirections] and the common animations options will be added
     * additionally pop to direction is going to be added
     *
     * @param fragment the fragment to get the nav graph
     * @param action the action to navigate
     * @param inclusive pop to inclusive by default is True
     * @param popToDestinationId the destination to pop to, if null is provided the navGraph start destination will be used
     */
    fun goToFragmentPopTo(
        fragment: Fragment?,
        action: NavDirections,
        inclusive: Boolean = true,
        popToDestinationId: Int? = null
    )

    /**
     * Go to a fragment using a destination Id and the common animations options will be added
     *
     * @param activity the activity to get the nav graph
     * @param destinationId the destination Id
     */
    fun goToFragment(activity: Activity?, destinationId: Int, bundle: Bundle? = null)

    /**
     * Go to a fragment using a [NavDirections] and the common animations options will be added
     * additionally pop to direction is going to be added
     *
     * @param activity the activity to get the nav graph
     * @param action the action to navigate
     * @param inclusive pop to inclusive by default is True
     * @param popToDestinationId the destination to pop to, if null is provided the navGraph start destination will be used
     */
    fun goToFragmentPopTo(
        activity: Activity?,
        action: NavDirections,
        inclusive: Boolean = true,
        popToDestinationId: Int? = null
    )

    /**
     * Go to a fragment using a [NavDirections] and the common animations options will be added
     * additionally pop to direction is going to be added
     *
     * @param activity the activity to get the nav graph
     * @param destinationId the destination id to navigate
     * @param inclusive pop to inclusive by default is True
     * @param popToDestinationId the destination to pop to, if null is provided the navGraph start destination will be used
     */
    fun goToFragmentPopTo(
        activity: Activity?,
        destinationId: Int,
        bundle: Bundle? = null,
        inclusive: Boolean = true,
        popToDestinationId: Int? = null
    )

    /**
     * Go back pops the back stack
     *
     * @param fragment the fragment to get the nav graph
     */
    fun goBack(fragment: Fragment?)

    /**
     * Go back pops the back stack
     *
     * @param fragment the fragment to get the nav graph
     * @param destinationId the destination fragment id
     */
    fun goBackPopTo(fragment: Fragment?, destinationId: Int, inclusive: Boolean = false)
}

class NavCommonsImpl(private val navHostFragmentId: Int) : NavCommons {

    override val options = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_exit_anim)
        .build()

    private fun getOptionsPopTo(popToDestinationId: Int, inclusive: Boolean) = NavOptions.Builder()
        .setPopUpTo(popToDestinationId, inclusive)
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_exit_anim)
        .build()

    override fun goToFragment(fragment: Fragment?, action: NavDirections) =
        fragment?.findNavController()?.navigate(action, options) ?: Unit

    override fun goToFragment(view: View, action: NavDirections) {
        Navigation.findNavController(view).navigate(action)
    }

    override fun goToFragmentPopTo(
        fragment: Fragment?,
        action: NavDirections,
        inclusive: Boolean,
        popToDestinationId: Int?
    ) =
        fragment?.findNavController()?.let {
            val popTo = popToDestinationId ?: it.graph.startDestinationId

            it.navigate(action, getOptionsPopTo(popTo, inclusive))
        } ?: Unit

    override fun goToFragment(activity: Activity?, destinationId: Int, bundle: Bundle?) =
        activity?.findNavController(navHostFragmentId)
            ?.navigate(destinationId, bundle, options) ?: Unit

    override fun goToFragmentPopTo(
        activity: Activity?,
        action: NavDirections,
        inclusive: Boolean,
        popToDestinationId: Int?
    ) =
        activity?.findNavController(navHostFragmentId)?.let {
            val popTo = popToDestinationId ?: it.graph.startDestinationId

            it.navigate(action, getOptionsPopTo(popTo, inclusive))
        } ?: Unit

    override fun goToFragmentPopTo(
        activity: Activity?,
        destinationId: Int,
        bundle: Bundle?,
        inclusive: Boolean,
        popToDestinationId: Int?
    ) =
        activity?.findNavController(navHostFragmentId)?.let {
            val popTo = popToDestinationId ?: it.graph.startDestinationId

            it.navigate(destinationId, bundle, getOptionsPopTo(popTo, inclusive))
        } ?: Unit

    override fun goBack(fragment: Fragment?) {
        fragment?.findNavController()?.popBackStack()
    }

    override fun goBackPopTo(fragment: Fragment?, destinationId: Int, inclusive: Boolean) {
        fragment?.findNavController()?.popBackStack(destinationId, inclusive)
    }

}