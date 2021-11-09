package com.choryan.quan.wanpicture.base

import android.app.Application

/**
 * Created by ChoRyan Quan on 2021/11/9 18:45.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class BaseApplication : Application() {

    companion object {
        lateinit var instance: BaseApplication
    }

    init {
        instance = this
    }

}