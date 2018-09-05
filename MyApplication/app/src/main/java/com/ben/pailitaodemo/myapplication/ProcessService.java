package com.ben.pailitaodemo.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;

/**
 * @author： BaiCha
 * @Time:2018/8/26
 * @description :
 */
public class ProcessService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Watcher watcher=new Watcher();
        watcher.createWatcher(String.valueOf(Process.myPid()));
    }
}
