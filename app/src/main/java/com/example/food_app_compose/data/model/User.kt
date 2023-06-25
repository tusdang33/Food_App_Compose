package com.example.food_app_compose.data.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class User(
    val id: String,
    val name: String?,
    val email: String,
    val role: Int,
    val image: String?
) : Parcelable