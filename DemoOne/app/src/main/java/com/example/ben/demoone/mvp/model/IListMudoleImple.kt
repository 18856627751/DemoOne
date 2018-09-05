package com.example.ben.demoone.mvp.model

/**
 *@author： ben
 *@Time:2018/8/9
 *@description :
 *
 */

class IListMudoleImple :IListModule{

    override fun loadList(onListLoadListener: IListModule.OnListLoadListener) {
        var list=ArrayList<String>()
        list.add("111")
        list.add("222")
        list.add("333")
        list.add("444")

        onListLoadListener.complete(list)
    }
}