package com.rayman.r_utils.format

import com.rayman.r_utils.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-08-18
 */
object TimeFormatUtil {
    const val yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss"
    const val yyyyMMdd = "yyyy-MM-dd"
    const val HHmmss = "HH:mm:ss"

    /**
     * 将日期转化为时间戳
     */
    fun formatTime(time: Long, pattern: String = yyyyMMddHHmmss): String {
        val formatTime = if (time.toString().length == 10) {
            // 如果是秒级的时间戳，补上三个0
            (time.toString() + "000").toLong()
        } else {
            time
        }
        val format = SimpleDateFormat(pattern, Locale.CHINA)
        return format.format(Date(formatTime))
    }

//    fun formatSecond(s: Long): String {
//        val ss = s % 60
//        var mm = s / 60
//        var hh = mm / 60
//        if (mm >= 60) {
//            mm %= 60
//        }
//        if (hh >= 24) {
//            hh %= 24
//        }
//        var result = ""
//        if (ss > 0) {
//            result = "$ss${ResourceUtil.getString(R.string.second)}"
//        }
//        if (mm > 0) {
//            result = "$mm${ResourceUtil.getString(R.string.minute)}" + result
//        }
//        if (hh > 0) {
//            result = "$hh${ResourceUtil.getString(R.string.hour)}" + result
//        }
//        return result
//    }
}