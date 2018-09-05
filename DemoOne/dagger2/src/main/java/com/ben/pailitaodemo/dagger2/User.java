package com.ben.pailitaodemo.dagger2;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;

/**
 * @author： BaiCha
 * @Time:2018/9/4
 * @description :
 */

public class User {

    @MyQualifier("one")
    public User(String param1){
        Log.e("bennnn","justOne"+param1);
    }

    @MyQualifier("two")
    public User(String param1,String param2){
        Log.e("bennnn",param1+":"+param2);
    }

    public void tool(){
        Log.e("bennn","tool");
    }
}
