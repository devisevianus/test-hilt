package com.devis.hilttest.data

import com.devis.hilttest.core.UserMdl
import retrofit2.Response
import retrofit2.http.POST

/**
 * Created by devis on 05/08/20
 */

interface ApiService {

    @POST("login")
    suspend fun postLogin(): Response<UserMdl>

}