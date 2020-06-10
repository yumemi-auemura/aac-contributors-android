package com.github.auemura.aaccontributors.ui.single

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import com.github.auemura.aaccontributors.R
import com.github.auemura.aaccontributors.databinding.FragmentSingleBinding
import com.github.auemura.aaccontributors.core.ext.viewBinding
import com.github.auemura.aaccontributors.ui.MainViewModel

@AndroidEntryPoint
class SingleFragment : Fragment(R.layout.fragment_single) {

    private val viewModel: MainViewModel by activityViewModels()
    private val binding: FragmentSingleBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.singleEpoxyRecyclerView.setController(SingleEpoxyController(viewLifecycleOwner, viewModel))
    }
}
