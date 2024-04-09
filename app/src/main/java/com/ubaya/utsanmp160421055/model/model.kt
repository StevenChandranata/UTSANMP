package com.ubaya.utsanmp160421055.model
import com.google.gson.annotations.SerializedName

data class user(
    val email:String?,
    val username:String?,
    val firstname:String?,
    val lastname:String?,
    val password:String?,
)
data class Game(
    val id: Int?,
    val title: String?,
    val description: String?,
    val imageUrl: String?,
    val date: String?,
    val creatorUsername: String?
)