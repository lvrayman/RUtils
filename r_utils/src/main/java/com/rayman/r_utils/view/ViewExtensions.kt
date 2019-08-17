package com.rayman.r_utils.view

import android.view.View

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-08-17
 */
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        if (isVisible != value) {
            visibility = if (value) View.VISIBLE else View.GONE
        }
    }