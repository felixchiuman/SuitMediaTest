package com.felix.suitmedia.data.api.service

class ApiHelper(val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}