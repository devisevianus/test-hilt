package com.devis.hilttest.core

import com.devis.hilttest.core.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers

/**
 * Created by devis on 05/08/20
 */

@InstallIn(ApplicationComponent::class)
@Module
class CoreModule {

    @Provides
    fun providesAppDispatcher(): AppDispatchers =
        AppDispatchers(Dispatchers.Main, Dispatchers.IO)

}