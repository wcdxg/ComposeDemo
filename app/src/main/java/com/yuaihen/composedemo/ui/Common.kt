package com.yuaihen.composedemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yuaihen.composedemo.R
import com.yuaihen.composedemo.WeViewModel
import com.yuaihen.composedemo.ui.theme.WeTheme

/**
 * Created by 我吃大西瓜.
 * on 2021/08/23
 */
@Composable
fun WeTopBar(title: String, onBack: (() -> Unit)? = null) {
    Box(
        Modifier
            .background(WeTheme.colors.background)
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Row(Modifier.height(48.dp)) {
            if (onBack != null) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    Modifier
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = WeTheme.colors.icon
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            val viewModel: WeViewModel = viewModel()
            Icon(
                painter = painterResource(id = R.drawable.ic_palette),
                contentDescription = "切换主题",
                Modifier.clickable(onClick = {
                    viewModel.theme = when (viewModel.theme) {
                        WeTheme.Theme.Light -> WeTheme.Theme.Dark
                        WeTheme.Theme.Dark -> WeTheme.Theme.NewYear
                        WeTheme.Theme.NewYear -> WeTheme.Theme.Light
                    }
                })
            )

        }
    }
}