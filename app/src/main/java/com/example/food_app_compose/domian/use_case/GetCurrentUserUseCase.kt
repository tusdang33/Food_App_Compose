package com.example.food_app_compose.domian.use_case

import com.example.food_app_compose.common.CCDispatcher
import com.example.food_app_compose.common.Dispatcher
import com.example.food_app_compose.common.Resource
import com.example.food_app_compose.domian.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
	private val authRepository: AuthRepository,
) {
	suspend operator fun <T> invoke(): Resource<T> {
		return authRepository.getCurrentUser()
	}
}