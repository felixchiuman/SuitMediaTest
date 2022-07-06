package com.felix.suitmedia.data.api.service

import com.felix.suitmedia.model.GetListUserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/users?page=2")
    suspend fun getUsers(): Response<GetListUserResponse>
}