package com.rayman.rutils_sample

import android.app.Application
import com.rayman.r_utils.log.RLog

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 3/5/21
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RLog.setTag("rayman-tag")
        RLog.info("MyApplication/onCreate/start")
    }
}