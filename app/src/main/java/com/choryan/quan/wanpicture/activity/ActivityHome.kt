package com.choryan.quan.wanpicture.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.choryan.quan.wanpicture.R
import com.choryan.quan.wanpicture.base.BaseActivity
import com.choryan.quan.wanpicture.constants.IntentConstants

class ActivityHome : BaseActivity(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun start(context: Context, userPreviousPosition: Boolean = true) {
            val intent = Intent(context, ActivityHome::class.java)
            intent.putExtra(IntentConstants.HOME_INTENT_USE_PREVIOUS_POSITION, userPreviousPosition)
            context.startActivity(intent)
            if (context is Activity) {
                context.finish()
                context.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out)
            }
        }
    }
}