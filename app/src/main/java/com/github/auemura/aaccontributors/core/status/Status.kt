package com.github.auemura.aaccontributors.core.status

sealed class Status<out T> {
    object Loading : Status<Nothing>()
    data class Success<T>(val data: T) : Status<T>()
    data class Failure(val throwable: Throwable) : Status<Nothing>()
}
