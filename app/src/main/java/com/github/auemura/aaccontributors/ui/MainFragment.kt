package com.github.auemura.aaccontributors.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.github.auemura.aaccontributors.R
import com.github.auemura.aaccontributors.core.ext.navigateSafely
import com.github.auemura.aaccontributors.databinding.MainFragmentBinding
import com.github.auemura.aaccontributors.core.ext.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: MainViewModel by activityViewModels()
    private val binding: MainFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
        viewModel.navigation.observe(viewLifecycleOwner, ::onNavigated)
    }

    private fun onNavigated(event: MainViewModel.Nav) {
        when (event) {
            is MainViewModel.Nav.OpenSingle -> navigateSafely(MainFragmentDirections.actionMainFragmentToSingleFragment())
        }
    }
}
