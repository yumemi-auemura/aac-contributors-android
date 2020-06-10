package com.github.auemura.aaccontributors.core.ext

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.github.auemura.aaccontributors.R
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

// ref: https://satoshun.github.io/2020/01/fragment-view-memory-leak/
fun <T : ViewDataBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> {
    return object : ReadOnlyProperty<Fragment, T> {
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            val view = thisRef.requireView()
            var binding = view.getTag(R.id.fragment_binding) as? T
            if (binding == null) {
                binding = DataBindingUtil.bind(view)!!
                binding.lifecycleOwner = viewLifecycleOwner // set LifecycleOwner
                view.setTag(R.id.fragment_binding, binding)
            }
            return binding
        }
    }
}

/**
 * 画面遷移 (同時押し対策向け、現在の画面に紐づくactionがあれば遷移)
 */
fun Fragment.navigateSafely(directions: NavDirections) {

    val navController = findNavController()

    val actionId = directions.actionId

    val destinationId = navController.currentDestination?.getAction(actionId)?.destinationId
        ?: navController.graph.getAction(actionId)?.destinationId

    if (destinationId != null && navController.currentDestination?.id != destinationId) {
        navController.navigate(directions)
    }
}
