package com.github.auemura.aaccontributors.core.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

@BindingAdapter("srcByUrl")
fun ImageView.setSrcByUrl(url: String?) {
    url?.let {
        this.load(it)
    }
}
