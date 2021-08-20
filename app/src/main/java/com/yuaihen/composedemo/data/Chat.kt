package com.yuaihen.composedemo.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Created by 我吃大西瓜.
 * on 2021/08/20
 */
data class Chat(var friend: User, var msgs: MutableList<Msg>) {
}


data class Msg(val from: User, val text: String) {
    var read: Boolean by mutableStateOf(false)
}

