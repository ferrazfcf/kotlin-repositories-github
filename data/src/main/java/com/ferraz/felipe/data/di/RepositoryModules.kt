package com.ferraz.felipe.data.di

import com.ferraz.felipe.domain.repositories.GitRepoInfoRepository
import com.ferraz.felipe.data.repositories.GitRepoInfoRepositoryImpl
import org.koin.dsl.module

val gitHubRepoInfoRepositoryModule = module {
    single<GitRepoInfoRepository> { GitRepoInfoRepositoryImpl(get()) }
}
