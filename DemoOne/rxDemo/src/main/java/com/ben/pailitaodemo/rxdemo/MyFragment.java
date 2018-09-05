package com.ben.pailitaodemo.rxdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Observable;
import java.util.Observer;
import io.reactivex.functions.Consumer;

/**
 * @author： BaiCha
 * @Time:2018/9/1
 * @description :
 */
public class MyFragment extends Fragment implements Observer {


    View v;
    TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v =View.inflate(getActivity(),R.layout.fra_me,null);
        text= v.findViewById(R.id.testOne);
        text.setText("这是一个文本");
        return v;
    }



    private void method() {
        //接受事件的消费者
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                text.setText(Thread.currentThread().getName()+"====accept:"+s);
            }
        };
    }


    @Override
    public void update(Observable observable, Object o) {
        Log.e("ben",observable.toString()+"::"+o.toString());
        text.setText(o.toString());
    }
}
