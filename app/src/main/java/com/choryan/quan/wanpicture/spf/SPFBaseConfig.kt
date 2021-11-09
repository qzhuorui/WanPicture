package com.choryan.quan.wanpicture.spf

/**
 * Created by ChoRyan Quan on 2021/11/10 10:07.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
object SPFBaseConfig : SPFDelegate() {
    override fun getSharedPreferencesName(): String = "wanP_base_config"

    var guideFirstShow by boolean(defaultValue = true)

    //首页应该显示第几个,每次开启显示下一个,会在每次打开应用时加1,所以默认值是-1
    var homeItemPresentationIndex by int(defaultValue = -1)
}