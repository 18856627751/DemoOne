package com.example.ben.demoone.mvp.present

import android.view.View
import com.example.ben.demoone.mvp.model.IListModule
import com.example.ben.demoone.mvp.model.IListMudoleImple
import com.example.ben.demoone.mvp.view.IView
import java.lang.ref.WeakReference

/**
 *@author： ben
 *@Time:2018/8/9
 *@description :
 *
 */

public class ListLoadPresent<T :IView>{


        lateinit var weakReference: WeakReference<IView>
        val listModule: IListModule=IListMudoleImple()

    constructor(iView: IView){
//        viewModule=iView
        weakReference=WeakReference<IView>(iView)
    }



    fun onDisAttach(){
        weakReference.clear()
    }

    open fun fetch(){
        if(weakReference.get()!=null){
            weakReference.get()!!.load()

            if(listModule!=null){
                listModule.loadList(object:IListModule.OnListLoadListener{
                    override fun complete(list: ArrayList<String>) {
                        if(weakReference.get()!=null){
                            weakReference.get()!!.show(list)
                        }
                    }
                })
            }
        }


    }
}