package com.felix.suitmedia.data.api.repository

import com.felix.suitmedia.data.api.service.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}