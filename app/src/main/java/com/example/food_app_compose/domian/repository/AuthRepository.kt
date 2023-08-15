package com.example.food_app_compose.domian.repository

import com.example.food_app_compose.common.Resource
import com.example.food_app_compose.data.model.User

interface AuthRepository {
    suspend fun <T> getCurrentUser(): Resource<T>
    suspend fun login(
        email: String,
        pass: String
    ): Resource<Unit>
    
    suspend fun logout(): Resource<Unit>
    suspend fun register(
        email: String,
        pass: String
    ): Resource<User>
    
    suspend fun updatePass(pass: String): Resource<Unit>
    suspend fun updateProfile(
        name: String,
        email: String
    ): Resource<Unit>
}