package com.example.food_app_compose.di

import com.example.food_app_compose.data.repository.AuthRepositoryImp
import com.example.food_app_compose.domian.repository.AuthRepository
import dagger.Provides
import javax.inject.Singleton

object ViewModelModule {
    @Singleton
    @Provides
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImp()
    }
}