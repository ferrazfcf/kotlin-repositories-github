package com.ferraz.felipe.kotlinRepositoriesGithub.di

import com.ferraz.felipe.kotlinRepositoriesGithub.ui.HomeActivity
import com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList.RepositoriesFragment
import com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList.RepositoriesViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val repositoriesFragmentModule = module {
    scope<HomeActivity> {
        fragment { RepositoriesFragment() }
    }
}

private val repositoriesViewModelModule = module {
    viewModel { RepositoriesViewModel(get()) }
}

val repositoriesPresentation = repositoriesFragmentModule + repositoriesViewModelModule
