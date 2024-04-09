package com.ubaya.utsanmp160421055.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.utsanmp160421055.model.User

class userViewModel (application: Application): AndroidViewModel(application){
        val userLD = MutableLiveData<ArrayList<User>>()
        val userLoadErrorLD = MutableLiveData<Boolean>()
        val loadingLD = MutableLiveData<Boolean>()
        val TAG = "volleyTag"
        private var queue: RequestQueue? = null

        fun refresh() {
            loadingLD.value = true
            userLoadErrorLD.value = false

            queue = Volley.newRequestQueue(getApplication())
            val url = "http://localhost/people/people.json"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    val sType = object : TypeToken<List<User>>() { }.type
                    val result = Gson().fromJson<List<User>>(it, sType)
                    userLD.value = result as ArrayList<User>?
                    loadingLD.value = false

                    Log.d("showvoley", result.toString())
                }
                    ,
                {
                    Log.d("showvoley", it.toString())
                    userLoadErrorLD.value = false
                    loadingLD.value = false
                })
            stringRequest.tag = TAG
            queue?.add(stringRequest)
        }
        override fun onCleared() {
            super.onCleared()
            queue?.cancelAll(TAG)
        }

}
