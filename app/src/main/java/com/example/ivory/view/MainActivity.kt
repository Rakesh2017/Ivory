package com.example.ivory.view

import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.ivory.R
import com.example.ivory.base.MvvmActivity
import com.example.ivory.network.NetworkCall
import com.example.ivory.repository.NetworkErrorModel
import com.example.ivory.viewmodel.MainActivityViewModel


class MainActivity : MvvmActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        findViewById<TextView>(R.id.title_tv).text = "Ivory"
    }

    override fun initData() {
        val mvvm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        findViewById<TextView>(R.id.title_tv).setOnClickListener {
            mvvm.getList()
        }


        mvvm.data.observe(this) {
            findViewById<TextView>(R.id.title_tv).text = it
        }

    }

    override fun addListener() {

    }

    override fun clickListeners() {
    }
}
