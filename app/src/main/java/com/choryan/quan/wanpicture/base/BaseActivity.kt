package com.choryan.quan.wanpicture.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.wanpicture.utils.CommonUtil

/**
 * Created by ChoRyan Quan on 2021/11/9 18:31.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
open class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    private val needHideStatusBar = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (needHideStatusBar) {
            CommonUtil.hideStatusBar(this)
        }
    }
}