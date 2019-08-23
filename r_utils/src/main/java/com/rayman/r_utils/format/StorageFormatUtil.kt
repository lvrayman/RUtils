package com.rayman.r_utils.format

import java.text.DecimalFormat

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-08-18
 */
object StorageFormatUtil {

    fun formatSizeGB(size: Long): String {
        val result: Float = size.toFloat() / 1024 / 1024 / 1024
        val df = DecimalFormat("0.00")
        return df.format(result) + "GB"
    }

    fun formatSizeMB(size: Long): String {
        val result: Float = size.toFloat() / 1024 / 1024
        val df = DecimalFormat("0.00")
        return df.format(result) + "MB"
    }

    fun formatSizeAuto(size: Long): String {
        var df = DecimalFormat("0.0")
        var result: Float = size.toFloat() / 1024 //KB
        if (result < 100) {
            return df.format(result) + "KB"
        }
        result /= 1024 //MB
        if (result < 1000) {
            return df.format(result) + "MB"
        }
        df = DecimalFormat("0.00")
        result /= 1024
        if (result < 1000) {
            return df.format(result) + "GB"
        }
        result /= 1024
        return df.format(result) + "TB"
    }

}