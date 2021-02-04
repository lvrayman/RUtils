package com.rayman.r_utils.log

import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-08-17
 */
object RLog {
    var isLog = true

    private var tag = "RLog"
    private val throwable = Throwable()

    private const val NEW_MESSAGE_SPLIT =
        "\n-----------------------------------------------------------------------------------------"
    private const val LINE_PREFIX = "\n----"
    private const val KEY_VALUE_SPLIT = "  :  "
    private const val HEADER_SPLIT = "    "
    private val sDateFormatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
    private val sDate = Date()


    private val stringBuilder = StringBuilder()

    fun setTag(tag: String) {
        this.tag = tag
    }

    fun verbose(where: String = "", vararg msg: Any) {
        if (isLog) {
            throwable.stackTrace[1]?.let {
                val list = arrayListOf<Any>()
                list.addAll(msg)
                val message = getMessage(it, where, list)
                val strLength = message.length
                var start = 0
                var end = 2000
                for (i in 0..99) {
                    //剩下的文本还是大于规定长度则继续重复截取并输出
                    if (strLength > end) {
                        Log.v(tag, message.substring(start, end))
                        start = end
                        end += 2000
                    } else {
                        Log.v(tag, message.substring(start, strLength))
                        break
                    }
                }
            }
        }
    }

    fun debug(where: String = "", vararg msg: Any) {
        if (isLog) {
            throwable.stackTrace[1]?.let {
                val list = arrayListOf<Any>()
                list.addAll(msg)
                val message = getMessage(it, where, list)
                val strLength = message.length
                var start = 0
                var end = 2000
                for (i in 0..99) {
                    //剩下的文本还是大于规定长度则继续重复截取并输出
                    if (strLength > end) {
                        Log.d(tag, message.substring(start, end))
                        start = end
                        end += 2000
                    } else {
                        Log.d(tag, message.substring(start, strLength))
                        break
                    }
                }
            }
        }

    }

    fun warn(where: String = "", vararg msg: Any) {
        if (isLog) {
            throwable.stackTrace[1]?.let {
                val list = arrayListOf<Any>()
                list.addAll(msg)
                val message = getMessage(it, where, list)
                val strLength = message.length
                var start = 0
                var end = 2000
                for (i in 0..99) {
                    //剩下的文本还是大于规定长度则继续重复截取并输出
                    if (strLength > end) {
                        Log.w(tag, message.substring(start, end))
                        start = end
                        end += 2000
                    } else {
                        Log.w(tag, message.substring(start, strLength))
                        break
                    }
                }
            }
        }
    }

    fun info(where: String, vararg msg: Any) {
        if (isLog) {
            throwable.stackTrace[1]?.let {
                val list = arrayListOf<Any>()
                list.addAll(msg)
                val message = getMessage(it, where, list)
                val strLength = message.length
                var start = 0
                var end = 2000
                for (i in 0..99) {
                    //剩下的文本还是大于规定长度则继续重复截取并输出
                    if (strLength > end) {
                        Log.d(tag, message.substring(start, end))
                        start = end
                        end += 2000
                    } else {
                        Log.d(tag, message.substring(start, strLength))
                        break
                    }
                }
            }
        }
    }

    fun error(where: String = "", vararg msg: Any) {
        if (isLog) {
            throwable.stackTrace[1]?.let {
                val list = arrayListOf<Any>()
                list.addAll(msg)
                val message = getMessage(it, where, list)
                val strLength = message.length
                var start = 0
                var end = 2000
                for (i in 0..99) {
                    //剩下的文本还是大于规定长度则继续重复截取并输出
                    if (strLength > end) {
                        Log.e(tag, message.substring(start, end))
                        start = end
                        end += 2000
                    } else {
                        Log.e(tag, message.substring(start, strLength))
                        break
                    }
                }
            }
        }
    }

    private fun getMessage(it: StackTraceElement, where: String, dataList: List<Any>): String {
        sDate.time = System.currentTimeMillis()
        stringBuilder.apply {
            delete(0, length)
            append(NEW_MESSAGE_SPLIT)
            append(LINE_PREFIX)
            append(sDateFormatter.format(sDate))
            append(HEADER_SPLIT);
            append(tag);
            append(HEADER_SPLIT);
            append("[${it.fileName}:${it.lineNumber}]" + where);
        }
        dataList.forEachIndexed { index, any ->
            if (index % 2 == 0) {
                stringBuilder.append(LINE_PREFIX)
            } else {
                stringBuilder.append(KEY_VALUE_SPLIT)
            }
            val string = if (any is Throwable) {
                getStringFromThrowable(any)
            } else {
                any.toString()
            }
            stringBuilder.append(string)
        }
        return stringBuilder.toString()
    }

    private fun getStringFromThrowable(e: Throwable?): String {
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