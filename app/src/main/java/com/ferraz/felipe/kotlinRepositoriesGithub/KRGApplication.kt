package com.ferraz.felipe.kotlinRepositoriesGithub

import android.app.Application
import com.ferraz.felipe.data.di.gitHubRepoInfoRepositoryModule
import com.ferraz.felipe.kotlinRepositoriesGithub.di.repositoriesPresentation
import com.ferraz.felipe.data.di.gitHubServiceModule
import com.ferraz.felipe.data.di.serviceImplModule
import com.ferraz.felipe.kotlinRepositoriesGithub.di.getTopStarKotlinGitHubRepositoriesUseCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.KoinExperimentalAPI
import org.koin.core.context.startKoin

class KRGApplication : Application() {

    @KoinExperimentalAPI
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@KRGApplication)
            fragmentFactory()
            modules(
                repositoriesPresentation
                        + serviceImplModule
                        + gitHubServiceModule
                        + gitHubRepoInfoRepositoryModule
                        + getTopStarKotlinGitHubRepositoriesUseCaseModule
            )
        }
    }
}
