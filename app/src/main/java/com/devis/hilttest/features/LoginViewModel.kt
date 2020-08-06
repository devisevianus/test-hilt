package com.devis.hilttest.features

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devis.hilttest.core.UserMdl
import com.devis.hilttest.core.AppDispatchers
import com.devis.hilttest.core.BaseViewState
import com.devis.hilttest.core.ResultState
import com.devis.hilttest.data.LoginRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by devis on 05/08/20
 */

class LoginViewModel @ViewModelInject constructor(
    private val repository: LoginRepository,
    private val dispatcher: AppDispatchers
) : ViewModel() {

    private val _mLoginResult = MutableLiveData<BaseViewState<UserMdl>>()
    val responseLogin: LiveData<BaseViewState<UserMdl>> = _mLoginResult

    fun postLogin() {
        viewModelScope.launch {
            val request = withContext(dispatcher.io) {
                repository.postLogin()
            }

            when (request) {
                is ResultState.Success -> {
                    _mLoginResult.value = BaseViewState.Success(request.data)
                }
                is ResultState.Error -> {
                    _mLoginResult.value = BaseViewState.Error(request.errorMessage)
                }
            }
        }
    }

}