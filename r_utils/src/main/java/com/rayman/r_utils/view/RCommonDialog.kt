package com.rayman.r_utils.view

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.rayman.r_utils.R

/**
 * @author 吕少锐 (lvrayman@gmail.com)
 * @version 2019-12-09
 */
class RCommonDialog(context: Context, @LayoutRes private val layoutId: Int = R.layout.dialog_common_r) :
    Dialog(context) {
    private val tvTitle: TextView by lazy { findViewById<TextView>(R.id.tv_title) }
    private val tvMessage by lazy { findViewById<TextView>(R.id.tv_message) }
    private val btnNegative by lazy { findViewById<Button>(R.id.btn_negative) }
    private val btnPosition by lazy { findViewById<Button>(R.id.btn_positive) }
    private var rootView: View = layoutInflater.inflate(layoutId, null)

    init {
        setContentView(rootView)
        if (btnPosition.text.isEmpty()) btnNegative.text = ResourceUtil.getString(R.string.ok_r)
        if (btnNegative.text.isEmpty()) btnPosition.text = ResourceUtil.getString(R.string.cancel_r)
        btnNegative.setOnClickListener { dismiss() }
        btnPosition.setOnClickListener { dismiss() }
    }

    fun hideNegativeButton(): RCommonDialog {
        btnNegative.visible = false
        return this
    }

    fun hidePositionButton(): RCommonDialog {
        btnPosition.visible = false
        return this
    }

    fun setPositiveText(text: String): RCommonDialog {
        btnPosition.text = text
        return this
    }

    fun setNegativeText(text: String): RCommonDialog {
        btnNegative.text = text
        return this
    }

    fun setPositiveClickListener(listener: (Dialog) -> Unit): RCommonDialog {
        btnPosition.setOnClickListener { listener(this) }
        return this
    }

    fun setNegativeClickListener(listener: (Dialog) -> Unit): RCommonDialog {
        btnNegative.setOnClickListener { listener(this) }
        return this
    }

    fun setTitle(title: String): RCommonDialog {
        tvTitle.text = title
        return this
    }

    fun setMessage(message: String): RCommonDialog {
        tvMessage.text = message
        return this
    }

    fun setDialogCancelable(cancelable: Boolean): RCommonDialog {
        setCancelable(cancelable)
        return this
    }

    fun setTextColor(
        titleColor: Int = -1,
        messageColor: Int = -1,
        buttonColor: Int = -1
    ): RCommonDialog {
        if (titleColor != -1) tvTitle.setTextColor(titleColor)
        if (messageColor != -1) tvMessage.setTextColor(messageColor)
        if (buttonColor != -1) {
            btnPosition.setTextColor(buttonColor)
            btnNegative.setTextColor(buttonColor)
        }
        return this
    }

    fun setButtonBackground(@DrawableRes positiveButtonBackground: Int = -1, @DrawableRes negativeButtonBackground: Int = -1): RCommonDialog {
        if (positiveButtonBackground != -1) {
            btnPosition.setBackgroundResource(positiveButtonBackground)
        }
        if (negativeButtonBackground != -1) {
            btnNegative.setBackgroundResource(negativeButtonBackground)
        }
        return this
    }

    fun setBackground(@DrawableRes dialogBackground: Int): RCommonDialog {
        rootView.setBackgroundResource(dialogBackground)
        return this
    }

}