package com.donfyy.kotlin.callback

import com.donfyy.java.callback.JavaCallback
import com.donfyy.java.callback.JavaManager


fun main() {
    JavaManager.setCallback(JavaCallback { })
    JavaManager.setCallback { }
    KtManager.setCallback(object : KtCallback {
        override fun call(s: String) {

        }
    })

//    KtManager.setCallback {  }  not allowed
    KtManager.setCallback2 { }
    KtManager.setCallback2(object : () -> Unit {
        override fun invoke() {
            TODO("Not yet implemented")
        }
    })
}

object KtManager {
    fun setCallback(a: KtCallback) {

    }
    fun setCallback2(a: () -> Unit) {

    }
}