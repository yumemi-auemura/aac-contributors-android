package com.github.auemura.aaccontributors.core.coroutine

import com.github.auemura.aaccontributors.ui.error.ErrorController
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

class ErrorCatcher @Inject constructor(
    private val errorController: ErrorController
) {
    val defaultPolicy: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        errorController.notifyException(throwable)
    }
}
