package com.rayman.r_utils.log

import android.annotation.SuppressLint
import java.io.ByteArrayOutputStream
import java.io.PrintStream

object ThrowableUtil {
    @SuppressLint("NewApi")
    fun getStringFromThrowable(e: Throwable?): String {
        if (e == null) return ""
        try {
            ByteArrayOutputStream().use { byteArrayOutputStream ->
                PrintStream(byteArrayOutputStream).use { printStream ->
                    e.printStackTrace(printStream)
                    return byteArrayOutputStream.toString()
                }
            }
        } catch (tempE: Throwable) {
        }
        return "ThrowableUtil error"
    }
}