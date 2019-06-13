package com.lz.kotlindemo.request

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 作者：created by cgw on 2019/6/13 22:04
 * 类注释：
 */
class HttpUtils {

    companion object{
        var baseUrl:String = "https://www.apiopen.top/"
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        var httpApi:HttpApi = retrofit.create(HttpApi::class.java)
    }

}