package com.example.food_app_compose.data.repository

import com.example.food_app_compose.common.Resource
import com.example.food_app_compose.data.model.User
import com.example.food_app_compose.domian.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.tasks.await

class AuthRepositoryImp : AuthRepository {
    private val firebaseAuth = FirebaseAuth.getInstance()
    @Suppress("UNCHECKED_CAST")
    override suspend fun <T> getCurrentUser(): Resource<T> {
        return try {
            Resource.Success(result = firebaseAuth.currentUser as T)
        } catch (e: Exception) {
            Resource.Fail(errorMessage = e.message)
        }
    }
    
    override suspend fun login(
        email: String,
        pass: String
    ): Resource<Unit> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, pass).await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Fail(errorMessage = e.message)
        }
    }
    
    override suspend fun logout(): Resource<Unit> {
        return try {
            firebaseAuth.signOut()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Fail(errorMessage = e.message)
        }
        
    }
    
    override suspend fun register(
        email: String,
        pass: String
    ): Resource<User> {
        return try {
            val fireUser = firebaseAuth.createUserWithEmailAndPassword(email, pass).await().user!!
            Resource.Success(User(fireUser.uid, null, email, 0, null))
        } catch (e: Exception) {
            Resource.Fail(errorMessage = e.message)
        }
    }
    
    override suspend fun updatePass(pass: String): Resource<Unit> {
        return try {
            firebaseAuth.currentUser!!.updatePassword(pass).await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Fail(errorMessage = e.message)
        }
    }
    
    override suspend fun updateProfile(
        name: String,
        email: String
    ): Resource<Unit> {
        return try {
            val profileUpdates = userProfileChangeRequest {
                displayName = name
            }
            firebaseAuth.currentUser!!.updateProfile(profileUpdates).await()
            firebaseAuth.currentUser!!.updateEmail(email).await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Fail(errorMessage = e.message)
        }
    }
}