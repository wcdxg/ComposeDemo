package com.yuaihen.composedemo.data

import androidx.annotation.DrawableRes
import com.yuaihen.composedemo.R

/**
 * Created by 我吃大西瓜.
 * on 2021/08/20
 */
data class User(
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int
) {
    companion object {
        val Me: User = User("wcdxg", "我吃大西瓜", R.drawable.avatar_huaji)

    }
}
