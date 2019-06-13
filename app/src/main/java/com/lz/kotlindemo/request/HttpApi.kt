package com.lz.kotlindemo.request

import com.lz.kotlindemo.bean.StoryBean
import retrofit2.Call
import retrofit2.http.GET

/**
 * 作者：created by cgw on 2019/6/13 22:11
 * 类注释：
 */
interface HttpApi {

    @GET("/novelApi")
    fun getStory() : Call<StoryBean>
}