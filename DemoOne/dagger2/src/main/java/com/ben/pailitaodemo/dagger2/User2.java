package com.ben.pailitaodemo.dagger2;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;

/**
 * @author： BaiCha
 * @Time:2018/9/4
 * @description :
 */
@Module
public class User2 {

    @Inject
    public User2(){
        Log.e("bennnn","User2");
    }

    public void tool(){
        Log.e("bennn","tool2");
    }
}
