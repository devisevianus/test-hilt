package com.devis.hilttest.data

import com.devis.hilttest.core.UserMdl
import com.devis.hilttest.core.ResultState
import com.devis.hilttest.core.fetchState
import javax.inject.Inject

/**
 * Created by devis on 05/08/20
 */

class LoginRepository @Inject constructor(
    private val remoteLoginDataSource: RemoteLoginDataSource
) {

    suspend fun postLogin(): ResultState<UserMdl> {
        return fetchState {
            val response = remoteLoginDataSource.postLogin()
            if (response.isSuccessful) {
                ResultState.Success(response.body())
            } else {
                ResultState.Error(response.message())
            }
        }
    }

}