package com.yuaihen.composedemo

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuaihen.composedemo.ui.theme.ComposeDemoTheme
import kotlinx.parcelize.Parcelize

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HelloViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme(darkTheme = true) {
                HelloScreen(viewModel)
//                Conversation(SampleData.conversationSample)
            }

        }
    }
}


class HelloViewModel : ViewModel() {

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    fun onNameChange(newName: String) {
        _name.value = newName
    }

}

@Composable
fun HelloScreen(helloViewModel: HelloViewModel) {
    var saveData = rememberSaveable {
        mutableStateOf(Message("Hello", "我吃大西瓜"))
    }

    val name by helloViewModel.name.observeAsState("")
    HelloContent(name = name, onNameChange = { helloViewModel.onNameChange(it) })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text(
            text = "Hello $name",
            Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary
        )

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("name") })
    }
}


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { msg ->
            MessageCard(msg)
        }
    }
}


@Preview(
    name = "My Preview",
    device = Devices.PIXEL_XL,
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun PreviewConversation() {
    Conversation(messages = SampleData.conversationSample)
}


@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        //remember将本地状态记录在内存中,并跟踪传递给mutableStateOf的值的变化
        //该值更新时,系统会自动重新绘制使用此状态的可组合项
        var isExpanded by remember { mutableStateOf(false) }

        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )

        Column(Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.name,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }

    }

}

//@Preview(name = "Light Mode")
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun PreviewMessageCard() {
    ComposeDemoTheme() {
        MessageCard(Message("Hello", "Jetpack compose"))
    }
}

@Parcelize
data class Message(val name: String, val body: String) : Parcelable