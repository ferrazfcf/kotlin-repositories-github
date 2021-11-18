package com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList

import android.util.Log
import androidx.lifecycle.*
import com.ferraz.felipe.domain.entities.GitHubRepositories
import com.ferraz.felipe.domain.entities.GitRepositoryInfo
import com.ferraz.felipe.domain.usecases.GetTopStarKotlinGitHubRepositoriesUseCase
import com.ferraz.felipe.domain.utils.ResultWrapper
import com.ferraz.felipe.kotlinRepositoriesGithub.utils.Event
import com.ferraz.felipe.kotlinRepositoriesGithub.utils.LoadingState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
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

    private var _errorState = Channel<Throwable>()
    val errorState: LiveData<Throwable>
        get() = _errorState.receiveAsFlow().asLiveData()

    init {
        Log.d("FCF1101", "ViewModel")
        _loadingState.value = Event(LoadingState.FIRST_PAGE)
        getTopStarKotlinGitHubRepositories()
    }

    fun buttonClicked() {
        sendErrorState(Throwable("ERROR"))
    }

    private fun getTopStarKotlinGitHubRepositories() {
        viewModelScope.launch {
            getTopStarKotlinGitHubRepositoriesUseCase(1, 10).collect {
                handleRepositoriesListResource(it)
            }
        }
    }

    private fun handleRepositoriesListResource(response: ResultWrapper<GitHubRepositories>) {
        Log.d("FCF", response.toString())
    }

    private fun sendErrorState(error: Throwable) {
        viewModelScope.launch {
            _errorState.send(error)
        }
    }
}
