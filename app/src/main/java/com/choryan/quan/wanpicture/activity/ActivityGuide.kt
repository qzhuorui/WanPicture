package com.choryan.quan.wanpicture.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.choryan.quan.wanpicture.R
import com.choryan.quan.wanpicture.base.BaseActivity
import com.choryan.quan.wanpicture.spf.SPFBaseConfig

class ActivityGuide : BaseActivity(R.layout.activity_guide) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SPFBaseConfig.guideFirstShow = false
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, ActivityGuide::class.java)
            context.startActivity(intent)
            if (context is Activity) {
                context.finish()
                context.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out)
            }
        }
    }
}