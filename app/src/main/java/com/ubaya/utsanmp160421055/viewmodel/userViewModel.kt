package com.ubaya.utsanmp160421055.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.utsanmp160421055.model.User
import org.json.JSONObject

class userViewModel (application: Application): AndroidViewModel(application){
        val userLD = MutableLiveData<ArrayList<User>>()
        val userLoadErrorLD = MutableLiveData<Boolean>()
        val currentUserLD = MutableLiveData<User>()
        val userRegisLD = MutableLiveData<Boolean>()
        val loadingLD = MutableLiveData<Boolean>()
        val TAG = "volleyTag"
        private var queue: RequestQueue? = null
        fun login() {
            loadingLD.value = true
            userLoadErrorLD.value = false

            queue = Volley.newRequestQueue(getApplication())
            val url = "http://10.0.2.2/utsanmp/user.php"
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
    fun checkCredentials(username: String, password: String): Boolean {
        val userList = userLD.value
        if (userList != null) {
            for (user in userList) {
                if (user.username == username && user.password == password) {
                    return true
                }
            }
        }
        return false
    }
    fun setCurrentUser(user: User) {
        currentUserLD.value = user
    }
    fun getCurrentUser(): User? {
        return currentUserLD.value
    }
    fun getCurrentUserByUsername(username: String): User? {
        val userList = userLD.value
        if (userList != null) {
            return userList.find { it.username == username }
        }
        return null
    }
    fun updateUserProfile(newFirstName: String, newLastName: String, newPassword: String, username: String) {
        val url = "http://10.0.2.2/utsanmp/updateUser.php"
        val requestQueue = Volley.newRequestQueue(getApplication())
        val stringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                Toast.makeText(getApplication(), "Profile user Updated!", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                Toast.makeText(getApplication(), "Error occurred: ${error.message}", Toast.LENGTH_SHORT).show()
            }) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["firstname"] = newFirstName
                params["lastname"] = newLastName
                params["password"] = newPassword
                params["username"] = username
                return params
            }
        }
        requestQueue.add(stringRequest)
    }
    fun registerUser(context: Context, username: String, firstname: String, lastname: String, email: String, password: String, imageProfil:String) {
        val url = "http://10.0.2.2/utsanmp/insertUser.php"
        val request = object : StringRequest(
            Method.POST, url,
            Response.Listener<String> { response ->
                userRegisLD.value = true
                Toast.makeText(context, "User registered successfully!", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                userRegisLD.value = false
                Toast.makeText(context, "Error occurred: ${error.message}", Toast.LENGTH_SHORT).show()
            }) {
            override fun getParams(): Map<String, String>? {
                val params = HashMap<String, String>()
                params["username"] = username
                params["firstname"] = firstname
                params["lastname"] = lastname
                params["email"] = email
                params["password"] = password
                params["imageProfil"] = imageProfil
                Log.d("showvoley", params.toString())
                return params
            }
        }
        Volley.newRequestQueue(context).add(request)
    }
    fun isUserLogIn(): Boolean {
        return userLD.value != null && userLD.value!!.isNotEmpty() && !userLD.value!![0].id.isNullOrEmpty()

    }
    override fun onCleared() {
            super.onCleared()
            queue?.cancelAll(TAG)
        }

}
