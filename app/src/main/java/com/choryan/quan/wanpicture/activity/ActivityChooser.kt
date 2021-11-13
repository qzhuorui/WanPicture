package com.choryan.quan.wanpicture.activity

import android.os.Bundle
import com.choryan.quan.wanpicture.R
import com.choryan.quan.wanpicture.base.BaseActivity
import com.choryan.quan.wanpicture.spf.SPFBaseConfig

/**
 * Created by ChoRyan Quan on 2021/11/9 18:40.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class ActivityChooser : BaseActivity(R.layout.activity_chooser) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //CommonUtil.deletePhotoConvertCacheFile(this)
        if (SPFBaseConfig.guideFirstShow) {
            ActivityGuide.start(this)
        } else {
            ActivityHome.start(this)
        }

    }
}