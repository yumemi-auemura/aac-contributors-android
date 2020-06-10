package com.github.auemura.aaccontributors.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
open class DispatcherProvider @Inject constructor(
    private val errorCatcher: ErrorCatcher
) {

    open val main: CoroutineDispatcher = Dispatchers.Main
    open val io: CoroutineDispatcher = Dispatchers.IO

    val mainContext: CoroutineContext
        get() = main.withHandler()

    val ioContext: CoroutineContext
        get() = io.withHandler()

    private fun CoroutineDispatcher.withHandler(): CoroutineContext = this + errorCatcher.defaultPolicy
}
