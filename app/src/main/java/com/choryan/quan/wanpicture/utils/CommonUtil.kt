package com.choryan.quan.wanpicture.utils

import android.app.Activity
import android.view.View
import android.view.Window

/**
 * Created by ChoRyan Quan on 2021/11/9 18:33.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
object CommonUtil {

    fun hideStatusBar(window: Window?) {
        window?.decorView?.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        }
    }

    fun hideStatusBar(activity: Activity) {
        activity.window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        }
    }

}