package com.rayman.rutils_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rayman.r_utils.log.RLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RLog.info("onCreate")
    }
}
