package com.example.ben.demoone.mvp.model

/**
 *@author： ben
 *@Time:2018/8/9
 *@description :
 *
 */

public interface IListModule {

    fun loadList( onListLoadListener:OnListLoadListener)
    //内部回调结口
    public interface OnListLoadListener{
        fun complete(list:ArrayList<String>)
    }
}