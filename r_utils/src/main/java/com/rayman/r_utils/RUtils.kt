package com.rayman.r_utils

import android.app.Application
import com.rayman.r_utils.view.ResourceUtil

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2020/4/25
 */
object RUtils {
    fun init(application: Application) {
        ResourceUtil.init(application)
    }
}