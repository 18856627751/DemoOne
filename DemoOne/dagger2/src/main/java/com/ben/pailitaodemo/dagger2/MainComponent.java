package com.ben.pailitaodemo.dagger2;

import dagger.Component;

/**
 * @author： BaiCha
 * @Time:2018/9/4
 * @description :
 */

@Component(modules = ParamModul.class)
public interface MainComponent {
    void injectTo(MainActivity activity);
}
