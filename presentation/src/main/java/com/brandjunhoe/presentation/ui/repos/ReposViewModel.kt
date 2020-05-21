package com.brandjunhoe.presentation.ui.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brandjunhoe.domain.entity.Repos
import com.brandjunhoe.domain.usecase.ReposUseCase
import com.brandjunhoe.presentation.BaseViewModel
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class ReposViewModel @Inject constructor(private val reposUseCase: ReposUseCase) : BaseViewModel() {

    private val _repos = MutableLiveData<MutableList<Repos>>()
    val repos: LiveData<MutableList<Repos>> get() = _repos

    init {
        getRepos("ehwnsghl2")
    }


    private fun getRepos(username: String) {
        reposUseCase.execute(ReposUseCase.Params(username)).subscribe({
            _repos.value = it as MutableList<Repos>?
        }, {
            Log.d("확인", "error ${it.message}")
            //_error.value = it.message
        }).addTo(compositeDisposable)


    }

}
