package com.lz.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.*
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.lz.kotlindemo.adapter.StoryAdapter
import com.lz.kotlindemo.bean.StoryBean
import com.lz.kotlindemo.request.HttpUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData() {
        HttpUtils.httpApi.getStory()
                .enqueue(object :retrofit2.Callback<StoryBean>{
                    override fun onResponse(call: Call<StoryBean>, response: Response<StoryBean>) {
                        val json = response.body()
                        Log.d("logInfo", "json--->$json")
                        val adapter = StoryAdapter(json!!.data, {})
                        recyclerView.adapter = adapter
                        val manager = LinearLayoutManager(this@MainActivity, VERTICAL,false)
                        recyclerView.layoutManager = manager
                    }

                    override fun onFailure(call: Call<StoryBean>, t: Throwable) {
                        Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
                    }
                })
    }
}
