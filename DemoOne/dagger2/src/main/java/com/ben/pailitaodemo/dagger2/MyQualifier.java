package com.ben.pailitaodemo.dagger2;

import javax.inject.Qualifier;

/**
 * @author： BaiCha
 * @Time:2018/9/4
 * @description :
 */
@Qualifier
public @interface MyQualifier{
    String value() default "";
}




