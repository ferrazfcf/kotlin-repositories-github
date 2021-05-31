package com.ferraz.felipe.data.di

import com.ferraz.felipe.data.service.GitHubServiceImpl
import com.ferraz.felipe.data.service.RetrofitImpl
import org.koin.dsl.module

val serviceImplModule = module {
    single { RetrofitImpl.provideMoshi() }
    single { RetrofitImpl.provideOkHttpClient() }
    single { RetrofitImpl.provideRetrofit(get(), get()) }
}

val gitHubServiceModule = module {
    single { GitHubServiceImpl.provideGitHubService(get()) }
}
