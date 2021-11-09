package com.choryan.quan.wanpicture.base

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Process
import com.choryan.quan.wanpicture.spf.SPFBaseConfig

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

    override fun onCreate() {
        super.onCreate()

        val processName: String = getProcessName(this, Process.myPid())
        if (!packageName.equals(processName, ignoreCase = true)) {
            return
        }

        SPFBaseConfig.homeItemPresentationIndex += 1

        otherInitFun()
    }

    private fun otherInitFun() {
        //do something
    }

    /**
     * @return null may be returned if the specified process not found
     */
    private fun getProcessName(cxt: Context, pid: Int): String {
        val am = cxt.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        if (am != null) {
            val runningApps = am.runningAppProcesses ?: return ""
            for (procInfo in runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName
                }
            }
        }
        return ""
    }
}