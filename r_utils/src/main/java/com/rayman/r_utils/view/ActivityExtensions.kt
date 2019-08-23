package com.rayman.r_utils.view

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-08-23
 */
fun Activity.hideKeyboard(): Boolean {
    currentFocus?.let {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(
            it.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
    return false
}