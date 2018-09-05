package com.ben.pailitaodemo.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * @author： BaiCha
 * @Time:2018/9/4
 * @description :
 */
@Module
public class ParamModul {

    public ParamModul(){

    }

    @MyQualifier("one")
    @Provides
    public User UseParam0(){
        return new User("paramJust");
    }


    @MyQualifier("two")
    @Provides
    public User UseParam1(){
        return new User("paramOne","paramTwo");
    }



}
