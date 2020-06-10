package com.github.auemura.aaccontributors.ui

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.auemura.aaccontributors.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
}