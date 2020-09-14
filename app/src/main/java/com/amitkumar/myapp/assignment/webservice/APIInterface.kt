package com.amitkumar.myapp.assignment.webservice

import com.amitkumar.myapp.assignment.constants.Constants
import com.amitkumar.myapp.assignment.models.UserProfile
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIInterface {

    @GET("/api/?results=10")
  //  fun getMusicData(): Call<Array<MusicAlbums>>

    fun getUserData(): Call<Array<UserProfile>>

    object APIServiceFactory {
        fun create(): APIInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.baseURL)
                .build()

            return retrofit.create(APIInterface::class.java);
        }
    }
}