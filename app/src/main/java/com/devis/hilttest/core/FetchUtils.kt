package com.devis.hilttest.core

import java.net.ConnectException

/**
 * Created by devis on 05/08/20
 */

suspend fun <T : Any> fetchState(call: suspend () -> ResultState<T>): ResultState<T> {
    return try {
        call.invoke()
    } catch (e: ConnectException) {
        ResultState.Error(e.message)
    } catch (e: Exception) {
        ResultState.Error(e.message)
    } catch (e: Throwable) {
        ResultState.Error(e.message)

    }
}