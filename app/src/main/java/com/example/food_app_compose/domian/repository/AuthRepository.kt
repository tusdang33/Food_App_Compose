package com.example.food_app_compose.domian.repository

import com.example.food_app_compose.data.model.User

interface AuthRepository {
    suspend fun <T> checkCurrentUser(): Result<T?>
    suspend fun login(email: String, pass: String): Result<Unit>
    suspend fun logout(): Result<Unit>
    suspend fun register(email: String, pass: String): Result<User>
    suspend fun getCurrentUserId(): Result<String>

    suspend fun updatePass(pass: String): Result<Unit>
    suspend fun updateProfile(name: String, email: String): Result<Unit>
}