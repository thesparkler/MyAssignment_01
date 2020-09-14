package com.amitkumar.myapp.assignment.store

import com.amitkumar.myapp.assignment.models.UserProfile
import com.amitkumar.myapp.assignment.webservice.APIInterface
import com.amitkumar.myapp.assignment.webservice.Result
import retrofit2.Call
import retrofit2.Response

//class DataStore private constructor() {
//
//    companion object {
//
//        fun getMusicAlbumDataWith(responseCallback: (Result<Array<MusicAlbums>>) -> Unit){
//            val service = APIInterface.APIServiceFactory.create()
//
//            service.getMusicData().enqueue(object : retrofit2.Callback<Array<MusicAlbums>> {
//                override fun onFailure(call: Call<Array<MusicAlbums>>, t: Throwable) {
//                    //Handle failure
//                    responseCallback(Result.error(Exception("Unable to fetch data")))
//                }
//
//                override fun onResponse(call: Call<Array<MusicAlbums>>, response: Response<Array<MusicAlbums>>) {
//                    val albumInfo = response.body()
//                    println("Request Success")
//                    print("CountryData is" + albumInfo)
//                    responseCallback(Result.success(albumInfo))
//                }
//
//            })
//        }
//    }
//}


class DataStore private constructor() {

    companion object {

        fun getUserDataWith(responseCallback: (Result<Array<UserProfile>>) -> Unit) {
            val service = APIInterface.APIServiceFactory.create()

            service.getUserData().enqueue(object : retrofit2.Callback<Array<UserProfile>> {
                override fun onFailure(call: Call<Array<UserProfile>>, t: Throwable) {
                    //Handle failure
                    responseCallback(Result.error(Exception("Unable to fetch data")))
                }

                override fun onResponse(
                    call: Call<Array<UserProfile>>,
                    response: Response<Array<UserProfile>>
                ) {
                    val userInfo = response.body()
                    println("Request Success")
                    responseCallback(Result.success(userInfo))
                }

            })
        }
    }
}