package com.ananth.mvvmkotlinsample.extensions

import android.view.View

fun View.setEnabledWithAlpha(isEnabled: Boolean, alpha: Float = 0.4f) {
    this.isEnabled = isEnabled
    this.alpha = alpha
}

