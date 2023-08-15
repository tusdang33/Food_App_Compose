package com.example.food_app_compose.common

sealed class Resource<T>(
    val result: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(result: T) : Resource<T>(result)
    class Fail<T>(
        result: T? = null,
        errorMessage: String?
    ) : Resource<T>(result, errorMessage)

    class Loading<T>(result: T? = null) : Resource<T>(result)
}

inline fun <reified T> Resource<T>.success(result: (T?) -> Unit): Resource<T> {
    return when(this) {
        is Resource.Success -> {
            result(this.result)
            this
        }

        else -> this
    }
}

inline fun <reified T> Resource<T>.fail(errorMessage: (String?) -> Unit): Resource<T> {
    return when(this) {
        is Resource.Fail -> {
            errorMessage(this.errorMessage)
            this
        }
        else -> this
    }
}
