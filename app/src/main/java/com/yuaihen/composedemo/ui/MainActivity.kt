package com.yuaihen.composedemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yuaihen.composedemo.R
import com.yuaihen.composedemo.SampleData

/**
 * Created by ZhouHanJun.
 * on 2022/12/13
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversationList(SampleData.conversationSample)
        }
    }
}

@Composable
fun ConversationList(message: List<Message>) {
    LazyColumn {
        message.map {
            item {
                MessageCard(it, 2) {
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ConversationList(SampleData.conversationSample)
}


@Composable
fun MessageCard(
    message: Message,
    clicks: Int,
    onclick: () -> Unit
) {
    MaterialTheme {
        Column {
            Button(onClick = onclick) {
                Text("I've been clicked $clicks times")
            }
            Row(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_picture),
                    contentDescription = "user photo",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                //是否展开
                var isExpanded by remember {
                    mutableStateOf(false)
                }
                val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)

                Column {
                    Text(
                        text = message.userName,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        color = surfaceColor,
                        modifier = Modifier
                            .clickable {
                                isExpanded = !isExpanded
                            }
                            .animateContentSize()
                            .padding(1.dp)
                    ) {
                        Text(
                            text = message.content,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(all = 4.dp),
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1
                        )
                    }

                }
            }
        }


    }
}

data class Message(val userName: String, val content: String)
