package com.ferraz.felipe.kotlinRepositoriesGithub.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList.RepositoriesFragment
import com.ferraz.felipe.kotlinRepositoriesGithub.databinding.HomeActivityBinding
import org.koin.androidx.fragment.android.replace
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.core.KoinExperimentalAPI

class HomeActivity : AppCompatActivity() {

    private val binding: HomeActivityBinding by lazy {
        HomeActivityBinding.inflate(layoutInflater)
    }

    @KoinExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupKoinFragmentFactory()

        supportFragmentManager.beginTransaction()
            .replace<RepositoriesFragment>(binding.homeRepositoriesListContainer.id)
            .commit()
    }
}
