package com.yuaihen.composedemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yuaihen.composedemo.data.Chat
import com.yuaihen.composedemo.data.Msg
import com.yuaihen.composedemo.data.User
import com.yuaihen.composedemo.ui.theme.WeTheme

/**
 * Created by 我吃大西瓜.
 * on 2021/08/20
 */
class WeViewModel : ViewModel() {

    var chats by mutableStateOf(
        listOf(
            Chat(
                User("zhangsan", "葛二蛋", R.drawable.avatar_doge),
                mutableListOf(
                    Msg(User("zhangsan", "葛二蛋", R.drawable.avatar_doge), "今天晚上吃什么?"),
                    Msg(User.Me, "土豆牛腩?"),
                    Msg(User("zhangsan", "葛二蛋", R.drawable.avatar_doge), "可以 我看看"),
                    Msg(User.Me, "或者青椒炒鸡"),
                    Msg(User("zhangsan", "葛二蛋", R.drawable.avatar_doge), "都行?"),
                    Msg(User.Me, "那就吃牛腩?"),
                    Msg(User("zhangsan", "葛二蛋", R.drawable.avatar_doge), "没问题 No Problem"),
                    Msg(User.Me, "OK 就这么愉快的决定了"),
                )
            ),
            Chat(
                User("lisi", "李四", R.drawable.avatar_cute),
                mutableListOf(
                    Msg(User("lisi", "李二狗", R.drawable.avatar_cute), "哈哈哈"),
                    Msg(User.Me, "你笑个屁呀"),
                )

            ),
        )
    )

    var theme by mutableStateOf(WeTheme.Theme.Light)
}