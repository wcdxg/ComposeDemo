package com.yuaihen.composedemo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yuaihen.composedemo.WeViewModel

/**
 * Created by 我吃大西瓜.
 * on 2021/08/23
 */

@Composable
fun ChatListTopBar() {
    WeTopBar(title = "微信飒飒飒飒")
}

@Composable
fun ChatList(viewModel: WeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Column(Modifier.fillMaxSize(1f)) {
        ChatListTopBar()

    }
}