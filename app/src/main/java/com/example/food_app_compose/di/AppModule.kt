package com.example.food_app_compose.di

import com.example.food_app_compose.common.CCDispatcher
import com.example.food_app_compose.common.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Dispatcher(CCDispatcher.IO)
	fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
	
	@Provides
	@Dispatcher(CCDispatcher.Default)
	fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}