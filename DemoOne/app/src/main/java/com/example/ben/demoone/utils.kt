package com.example.ben.demoone

import android.content.Context
import android.widget.Toast

/**
 *@author： ben
 *@Time:2018/8/9
 *@description :
 *
 */

fun Context.toast(str:String){
    Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
}