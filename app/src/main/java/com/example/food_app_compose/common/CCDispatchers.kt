package com.example.food_app_compose.common

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val ccDispatcher: CCDispatcher)

enum class CCDispatcher {
	IO,
	Default
}
