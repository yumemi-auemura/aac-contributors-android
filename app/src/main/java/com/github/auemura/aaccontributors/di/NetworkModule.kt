package com.github.auemura.aaccontributors.di

import com.github.auemura.aaccontributors.client.github.GitHubApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.github.com/")
            .applyKotlinXSerializationAsConverterFactory()
            .build()
    }

    @Provides
    @Singleton
    fun provideGitHubApiService(retrofit: Retrofit): GitHubApiService = retrofit.create(GitHubApiService::class.java)

    private fun Retrofit.Builder.applyKotlinXSerializationAsConverterFactory() = apply {
        val mediaType = "application/json".toMediaType()
        val json = Json(JsonConfiguration.Stable.copy(ignoreUnknownKeys = false)).asConverterFactory(mediaType)
        addConverterFactory(json)
    }
}
