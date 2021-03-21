package com.ydhnwb.starter_app_mvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val num = MutableLiveData(0)

    //.value or .setValue is executed on MainThread
    //.postValue or .setPostValue is executed on Other thread
    //please be aware of it. If some UI didnt spport change on other thread,
    //you must be set it using .value or .setValue
    //some UI's component support .postValue
    fun increment(){
        val currentNum = num.value
        num.value = currentNum?.plus(1)
    }

    fun decrement(){
        val currentNum = num.value
        num.value = currentNum?.minus(1)
    }

    //this will make num live data available to observe from activity
    fun listenToNum() = num
}