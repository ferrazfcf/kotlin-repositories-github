package com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferraz.felipe.domain.entities.GitHubRepositories
import com.ferraz.felipe.domain.entities.GitRepositoryInfo
import com.ferraz.felipe.domain.usecases.GetTopStarKotlinGitHubRepositoriesUseCase
import com.ferraz.felipe.domain.utils.ResultWrapper
import com.ferraz.felipe.kotlinRepositoriesGithub.utils.Event
import com.ferraz.felipe.kotlinRepositoriesGithub.utils.LoadingState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoriesViewModel(
    private val getTopStarKotlinGitHubRepositoriesUseCase: GetTopStarKotlinGitHubRepositoriesUseCase
) : ViewModel() {

    private var _repositoriesList = MutableLiveData<GitRepositoryInfo>()
    val repositoriesList: LiveData<GitRepositoryInfo>
        get() = _repositoriesList

    private var _loadingState = MutableLiveData<Event<LoadingState>>()
    val loadingState: LiveData<Event<LoadingState>>
        get() = _loadingState

    private var _errorState = MutableLiveData<Throwable>()
    val errorState: LiveData<Throwable>
        get() = _errorState

    init {
        _loadingState.value = Event(LoadingState.FIRST_PAGE)
        getTopStarKotlinGitHubRepositories()
    }

    private fun getTopStarKotlinGitHubRepositories() {
        viewModelScope.launch {
            getTopStarKotlinGitHubRepositoriesUseCase().collect {
                handleRepositoriesListResource(it)
            }
        }
    }

    private fun handleRepositoriesListResource(response: ResultWrapper<GitHubRepositories>) {
        Log.d("FCF", response.toString())
    }
}