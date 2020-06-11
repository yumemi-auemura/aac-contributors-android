package com.github.auemura.aaccontributors.client.github.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contributor(

    @SerialName("login")
    val login: String,

    @SerialName("id")
    val id: Long,

    @SerialName("node_id")
    val nodeId: String? = null,

    @SerialName("avatar_url")
    val avatarUrl: String? = null,

    @SerialName("gravatar_id")
    val gravatarId: String? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("html_url")
    val htmlUrl: String? = null,

    @SerialName("followers_url")
    val followersUrl: String? = null,

    @SerialName("following_url")
    val followingUrl: String? = null,

    @SerialName("gists_url")
    val gistsUrl: String? = null,

    @SerialName("starred_url")
    val starredUrl: String? = null,

    @SerialName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @SerialName("organizations_url")
    val organizationsUrl: String? = null,

    @SerialName("repos_url")
    val reposUrl: String? = null,

    @SerialName("events_url")
    val eventsUrl: String? = null,

    @SerialName("received_events_url")
    val receivedEventsUrl: String? = null,

    @SerialName("type")
    val type: String? = null,

    @SerialName("site_admin")
    val siteAdmin: Boolean? = null,

    @SerialName("contributions")
    val contributions: Int? = null
)

typealias ContributorResponse = List<Contributor>
