package com.devis.hilttest.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.devis.hilttest.MainActivity
import com.devis.hilttest.R
import com.devis.hilttest.core.BaseViewState
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

/**
 * Created by devis on 05/08/20
 */

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val mViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            mViewModel.postLogin()
        }

        initObserve()
    }

    private fun initObserve() {
        mViewModel.apply {
            responseLogin.observe(this@LoginActivity, Observer {
                when (it) {
                    is BaseViewState.Success -> {
                        Timber.d("Success call api %s", Gson().toJson(it.data))
                        MainActivity.startThisActivity(this@LoginActivity)
                    }
                    is BaseViewState.Error -> {
                        Timber.d("Error call api %s", it.errorMessage)
                    }
                }
            })
        }
    }

}