package com.github.auemura.aaccontributors.ui.collection

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.github.auemura.aaccontributors.R
import com.github.auemura.aaccontributors.core.ext.navigateSafely
import com.github.auemura.aaccontributors.core.ext.viewBinding
import com.github.auemura.aaccontributors.databinding.FragmentCollectionBinding
import com.github.auemura.aaccontributors.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CollectionFragment : Fragment(R.layout.fragment_collection) {

    private val viewModel: MainViewModel by activityViewModels()
    private val binding: FragmentCollectionBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.collectionEpoxyRecyclerView.setController(CollectionEpoxyController(viewLifecycleOwner, viewModel))
        viewModel.navigation.observe(viewLifecycleOwner, ::onNavigated)
    }

    private fun onNavigated(event: MainViewModel.Nav) {
        when (event) {
            is MainViewModel.Nav.OpenSingle -> {
                Log.d("event is ", event.toString())
                navigateSafely(CollectionFragmentDirections.actionCollectionFragmentToSingleFragment())
            }
        }
    }
}
