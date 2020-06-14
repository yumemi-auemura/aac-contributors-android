package com.github.auemura.aaccontributors.ui.single

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.airbnb.epoxy.TypedEpoxyController
import com.github.auemura.aaccontributors.core.status.Status
import com.github.auemura.aaccontributors.domain.github.ContributorEntity
import com.github.auemura.aaccontributors.ui.MainViewModel

class SingleEpoxyController(
    lifecycleOwner: LifecycleOwner,
    viewModel: MainViewModel
) : TypedEpoxyController<Status<List<ContributorEntity>>>() {

    init {
        viewModel.contributors.observe(lifecycleOwner, ::setData)
    }

    override fun buildModels(data: Status<List<ContributorEntity>>?) {
        Log.d("buildModels", "$data")
    }
}
