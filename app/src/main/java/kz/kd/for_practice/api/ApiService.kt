package kz.kd.for_practice.api

import kz.kd.for_practice.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}