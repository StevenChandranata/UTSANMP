package com.ubaya.utsanmp160421055.model
import com.google.gson.annotations.SerializedName
data class User(
    val username:String?,
    val firstname:String?,
    val lastname:String?,
    val email:String?,
    val password:String?,
    @SerializedName("imageProfil") val imageProfil: String?
)
data class Game(
    @SerializedName("idgame") val idGame: String?,
    val title: String,
    val description: String,
    val imageUrl: String,
    val creatorUsername: String,
    val descriptiondetail: List<String>
)
