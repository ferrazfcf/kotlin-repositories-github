package com.ferraz.felipe.data.service

import com.ferraz.felipe.data.service.api.GitHubService
import retrofit2.Retrofit

object ServiceImpl {

    fun provideGitHubService(retrofit: Retrofit): GitHubService =
        retrofit.create(GitHubService::class.java)
}
