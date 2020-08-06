package com.devis.hilttest.data

import com.devis.hilttest.features.LoginDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Created by devis on 05/08/20
 */

@InstallIn(ApplicationComponent::class)
@Module
object DataModule {

    @Provides
    fun provideApiService(): ApiService {
        return ApiClient.retrofitClient("https://5efb619c80d8170016f76501.mockapi.io/api/v1/")
            .create(ApiService::class.java)
    }

    @Provides
    fun provideRemoteLoginDataSource(apiService: ApiService): LoginDataSource {
        return RemoteLoginDataSource(apiService)
    }

}