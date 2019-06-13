package com.lz.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.kotlindemo.R
import com.lz.kotlindemo.bean.StoryBean
import kotlinx.android.synthetic.main.item_story.view.*

/**
 * 作者：created by cgw on 2019/6/13 22:45
 * 类注释：
 */
class StoryAdapter(val datas: List<StoryBean.DataBean>, val itemClickListener: (StoryBean.DataBean)->Unit): RecyclerView.Adapter<StoryAdapter.mViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_story,null, false)
        return mViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.bindDatas(datas[position])
        Log.d("logInfo", "datas[position]--->"+datas[position].bookname)
    }



    class mViewHolder(val view: View, val itemClickListener: (StoryBean.DataBean) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindDatas(bean: StoryBean.DataBean){
            view.tvTitle.text = bean.bookname
            view.tvContent.text = bean.introduction
            view.setOnClickListener {
                itemClickListener(bean)
            }
        }
    }
}