package com.yuaihen.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.yuaihen.composedemo.ui.Home
import com.yuaihen.composedemo.ui.theme.WeTheme

/**
 * Created by 我吃大西瓜.
 * on 2021/08/20
 */
class WeChatActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WeTheme() {
                Home()
            }
        }
    }
}