package com.github.auemura.aaccontributors.ui.single

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.airbnb.epoxy.TypedEpoxyController
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import com.github.auemura.aaccontributors.ui.MainViewModel

class SingleEpoxyController(lifecycleOwner: LifecycleOwner, viewModel: MainViewModel) : TypedEpoxyController<List<ContributorEntity>>() {

    init {
        viewModel.contributors.observe(lifecycleOwner, ::buildModels)
    }

    override fun buildModels(data: List<ContributorEntity>?) {
        Log.d("buildModels", "$data")
    }
}
