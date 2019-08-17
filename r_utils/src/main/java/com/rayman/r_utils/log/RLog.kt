package com.rayman.r_utils.log

import android.util.Log

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-08-17
 */
object RLog {
    var isLog = true

    private var m_tag = "RLog"

    fun setTag(tag: String) {
        m_tag = tag
    }

    fun debug(msg: String) {
        if (isLog) {
            Throwable().stackTrace[1]?.let {
                Log.d(m_tag, "[" + it.fileName + ":" + it.lineNumber + "]: " + msg)
            }
        }

    }

    fun warn(msg: String) {
        if (isLog) {
            Throwable().stackTrace[1]?.let {
                Log.w(m_tag, "[" + it.fileName + ":" + it.lineNumber + "]: " + msg)
            }
        }
    }

    fun info(msg: String) {
        if (isLog) {
            Throwable().stackTrace[1]?.let {
                Log.i(m_tag, "[" + it.fileName + ":" + it.lineNumber + "]: " + msg)
            }
        }
    }

    fun error(msg: String) {
        if (isLog) {
            Throwable().stackTrace[1]?.let {
                Log.e(m_tag, "[" + it.fileName + ":" + it.lineNumber + "]: " + msg)
            }
        }
    }
}