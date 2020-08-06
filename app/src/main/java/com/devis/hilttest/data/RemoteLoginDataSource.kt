package com.devis.hilttest.data

import com.devis.hilttest.features.LoginDataSource
import com.devis.hilttest.core.UserMdl
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by devis on 05/08/20
 */

class RemoteLoginDataSource @Inject constructor(
    private val apiService: ApiService
) : LoginDataSource {

    override suspend fun postLogin(): Response<UserMdl> {
        return apiService.postLogin()
    }

}