package com.github.auemura.aaccontributors.repository;

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleRepository @Inject constructor() {

    fun greeting(): Flow<String> = flow {
        emit("Hello!")
        delay(1_000)
        emit("こんにちは！")
    }
}
