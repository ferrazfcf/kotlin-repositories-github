package com.ferraz.felipe.kotlinRepositoriesGithub.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ferraz.felipe.kotlinRepositoriesGithub.databinding.HomeActivityBinding
import com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList.RepositoriesFragment
import org.koin.androidx.fragment.android.replace
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.core.KoinExperimentalAPI

class HomeActivity : AppCompatActivity() {

    private val binding: HomeActivityBinding by lazy {
        HomeActivityBinding.inflate(layoutInflater)
    }

    @KoinExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace<RepositoriesFragment>(binding.homeRepositoriesListContainer.id)
            .commit()
    }
}

//fun Activity.makeStatusBarTransparent() {
//    window.apply {
//        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
//        statusBarColor = Color.TRANSPARENT
//    }
//}
//
//fun View.setMarginTop(marginTop: Int) {
//    val menuLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
//    menuLayoutParams.setMargins(0, marginTop, 0, 0)
//    this.layoutParams = menuLayoutParams
//}
