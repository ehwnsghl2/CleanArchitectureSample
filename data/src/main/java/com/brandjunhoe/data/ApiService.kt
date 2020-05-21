package com.brandjunhoe.data

import com.brandjunhoe.data.entity.ReposEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/users/{username}/repos")
    fun repos(@Path("username") username: String): Single<List<ReposEntity>>



}