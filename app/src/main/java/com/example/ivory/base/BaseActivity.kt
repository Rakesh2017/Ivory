package com.example.ivory.base

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
        addListener()
        clickListeners()
    }
    public abstract fun getLayoutId() : Int
    public abstract fun initView()
    public abstract fun initData()
    public abstract fun addListener()
    public abstract fun clickListeners()
}