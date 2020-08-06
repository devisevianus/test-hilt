package com.devis.hilttest.features

import com.devis.hilttest.core.UserMdl
import retrofit2.Response

/**
 * Created by devis on 05/08/20
 */

interface LoginDataSource {

    suspend fun postLogin(): Response<UserMdl>

}