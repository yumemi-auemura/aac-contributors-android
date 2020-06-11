package com.github.auemura.aaccontributors.ui.collection

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.airbnb.epoxy.TypedEpoxyController
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import com.github.auemura.aaccontributors.ui.MainViewModel
import com.github.auemura.aaccontributors.viewSingleItem

class CollectionEpoxyController(lifecycleOwner: LifecycleOwner, private val viewModel: MainViewModel) :
    TypedEpoxyController<List<ContributorEntity>>() {

    init {
        viewModel.contributors.observe(lifecycleOwner, ::setData)
    }

    override fun buildModels(data: List<ContributorEntity>?) {
        Log.d("buildModels", "$data")
        data?.forEach {
            viewSingleItem {
                id(it.id)
                item(it)
                viewModel(viewModel)
            }
        }
    }
}
