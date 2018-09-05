package com.ben.pailitaodemo.rxdemo

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*
import java.util.function.Consumer
import kotlin.math.log

/**
 *@author：  BaiCha
 *@Time:2018/9/2
 *@description :
 *
 */

class ObserverPer : Observable(){

    companion object {
        var instance=ObserverPer()
    }

    //通知观察者更新数据
    fun notifyStepChange(step: String) {


        //关键方法，必须写，具体实现可以查看源码
        setChanged()//设置changeFlag

        notifyObservers(step)//通知观察者
    }
}