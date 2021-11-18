package com.ferraz.felipe.kotlinRepositoriesGithub

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import com.ferraz.felipe.data.di.gitHubRepoInfoRepositoryModule
import com.ferraz.felipe.kotlinRepositoriesGithub.di.repositoriesPresentation
import com.ferraz.felipe.data.di.gitHubServiceModule
import com.ferraz.felipe.data.di.serviceImplModule
import com.ferraz.felipe.kotlinRepositoriesGithub.di.getTopStarKotlinGitHubRepositoriesUseCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class KRGApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)

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
