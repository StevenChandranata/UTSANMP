package com.ubaya.utsanmp160421055.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.ubaya.utsanmp160421055.model.Game

class GameDetailViewModel (application: Application) : AndroidViewModel(application) {
    val gameLD = MutableLiveData<Game>()
    private val requestQueue: RequestQueue = Volley.newRequestQueue(application)

    fun fetch(gameId: String) {
        val url = "http://10.0.2.2/utsanmp/gameNews.php?idgame=${gameId}"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val gson = Gson()
                val game = gson.fromJson(response.getJSONObject(0).toString(), Game::class.java)
                gameLD.value = game
            },
            { error ->
                error.printStackTrace()
            }
        )
        requestQueue.add(jsonArrayRequest)
    }
}


