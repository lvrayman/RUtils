package com.rayman.r_utils.view

import android.app.Application
import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2020/4/12
 */
object ResourceUtil {
    private lateinit var application: Application

    fun init(application: Application) {
        this.application = application
    }

    fun getString(id: Int): String {
        return application.resources.getString(id)
    }

    fun getColor(id: Int): Int {
        return ContextCompat.getColor(application, id)
    }

    fun getPx(id: Int): Int {
        return application.resources.getDimensionPixelSize(id)
    }

    fun getColorStateList(id: Int): ColorStateList? {
        return ContextCompat.getColorStateList(application, id)
    }

    fun px2dp(pxValue: Float): Int {
        val scale = application.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun dp2px(dpValue: Float): Int {
        val scale = application.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 设置屏幕宽度，单位dp，在启动Activity的setContentView之前调用，粗暴解决屏幕适配问题
     */
    fun setCustomDensity(activity: AppCompatActivity, application: Application, width: Int = 360) {
        var nonCompatDensity: Float = 0.toFloat()
        var nonCompatScaledDensity: Float = 0.toFloat()
        val appDisplayMetrics = application.resources.displayMetrics
        if (nonCompatDensity == 0f) {
            nonCompatDensity = appDisplayMetrics.density
            nonCompatScaledDensity = appDisplayMetrics.scaledDensity
            application.registerComponentCallbacks(object : ComponentCallbacks {
                override fun onConfigurationChanged(newConfig: Configuration?) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        nonCompatScaledDensity = application.resources.displayMetrics.scaledDensity
                    }
                }

                override fun onLowMemory() {

                }
            })
        }
        val targetDensity = appDisplayMetrics.widthPixels / width.toFloat()
        val targetScaledDensity = targetDensity * (nonCompatScaledDensity / nonCompatDensity)
        val targetDensityDpi = (160 * targetDensity).toInt()

        appDisplayMetrics.density = targetDensity
        appDisplayMetrics.scaledDensity = targetScaledDensity
        appDisplayMetrics.densityDpi = targetDensityDpi

        val activityDisplayMetrics = activity.resources.displayMetrics
        activityDisplayMetrics.density = targetDensity
        activityDisplayMetrics.scaledDensity = targetScaledDensity
        activityDisplayMetrics.densityDpi = targetDensityDpi
    }

    fun getStatusBarHeight(context: Context): Int {
        var height = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            height = context.resources.getDimensionPixelSize(resourceId)
        }
        return height
    }
}