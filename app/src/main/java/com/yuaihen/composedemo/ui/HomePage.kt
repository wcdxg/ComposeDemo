package com.yuaihen.composedemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yuaihen.composedemo.WeViewModel

/**
 * Created by 我吃大西瓜.
 * on 2021/08/20
 */

@Composable
fun HomePage() {
    val viewModel = viewModel<WeViewModel>()

}

@Composable
fun Home() {
    val viewModel = viewModel<WeViewModel>()
    Box {
        Column(Modifier.fillMaxSize()) {
            val pagerState = kotlin.run {
                remember(viewModel.theme) {
                    PagerState(maxPage = 3)
                }
            }
            //创建ViewPager
            Pager(state = pagerState, Modifier.weight(1f)) {
                when (page) {
//                    0 -> ChatList()
//                    1 -> ContactList()
//                    2 -> DiscoveryList()
//                    3 -> MeList()
                }
            }
        }
    }
}