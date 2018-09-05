package com.example.ben.demoone

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.support.annotation.RequiresApi
import android.util.DisplayMetrics
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ben.demoone.mvp.present.ListLoadPresent
import com.example.ben.demoone.mvp.view.IView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.lang.reflect.AccessibleObject.setAccessible



class MainActivity : AppCompatActivity(),IView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun load() {
        toast("加载中")
    }

    override fun show(list: ArrayList<String>) {
    }





}
