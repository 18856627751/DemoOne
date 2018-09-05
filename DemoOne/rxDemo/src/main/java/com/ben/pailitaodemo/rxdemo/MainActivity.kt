package com.ben.pailitaodemo.rxdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var fra:MyFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fra =MyFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.linear,fra)
        transaction.commit()

        ObserverPer.instance.addObserver(fra)

    }



    fun onClick(v: View){

        ObserverPer.instance.notifyStepChange("hello");
    }

    override fun onDestroy() {
        super.onDestroy()
        ObserverPer.instance.deleteObserver(fra)
    }
}
