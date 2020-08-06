package com.devis.hilttest.core

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by devis on 05/08/20
 */

class AppDispatchers @Inject constructor(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
)