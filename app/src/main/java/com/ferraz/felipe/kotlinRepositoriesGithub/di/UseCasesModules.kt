package com.ferraz.felipe.kotlinRepositoriesGithub.di

import com.ferraz.felipe.domain.usecases.GetTopStarKotlinGitHubRepositoriesUseCase
import org.koin.dsl.module

val getTopStarKotlinGitHubRepositoriesUseCaseModule = module {
    single { GetTopStarKotlinGitHubRepositoriesUseCase(get()) }
}
