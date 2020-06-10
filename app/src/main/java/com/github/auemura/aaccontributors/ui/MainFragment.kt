package com.github.auemura.aaccontributors.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.auemura.aaccontributors.R
import com.github.auemura.aaccontributors.databinding.MainFragmentBinding
import com.github.auemura.aaccontributors.ext.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel by activityViewModels<MainViewModel>()
    private val binding by viewBinding<MainFragmentBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
    }
}
