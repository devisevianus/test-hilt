package com.devis.hilttest.core

import java.io.Serializable

/**
 * Created by devis on 05/08/20
 */

class UserMdl(
    val id: Int,
    val name: String,
    val role: String
) : Serializable