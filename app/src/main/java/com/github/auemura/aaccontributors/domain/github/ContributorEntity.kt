package com.github.auemura.aaccontributors.domain.github

data class ContributorEntity(
    val id: Long,
    val login: String,
    val avatarUrl: String?,
    val contributions: Int
)
