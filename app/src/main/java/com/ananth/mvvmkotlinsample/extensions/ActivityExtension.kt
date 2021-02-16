package com.ananth.mvvmkotlinsample.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.os.Bundle


fun Activity.goToActivity(newActivity: Class<*>){
    val intent= Intent(this, newActivity)
    startActivity(intent)
}

fun Activity.goToActivityWithBundle(newActivity: Class<*>,bundle: Bundle){
    val intent=Intent(this, newActivity)
    intent.putExtra("bundle",bundle)
    startActivity(intent)
}

fun Context.hideKeyboard(){
    val context=this
    val activity=context as Activity
    val windowToken=activity.window.decorView.rootView.windowToken
    val inputService=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputService.hideSoftInputFromWindow(windowToken,0)
}