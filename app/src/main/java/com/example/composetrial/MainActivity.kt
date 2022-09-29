package com.example.composetrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetrial.data.Message
import com.example.composetrial.data.SampleData
import com.example.composetrial.ui.theme.ComposeTrialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTrialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DefaultView()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text("Hello $name!")
        Text(text = "What are you up too, $name")
    }

}

@Composable
fun ImageCard(resId: Int){
    Image(painter = painterResource(id = resId), contentDescription = "scenary", modifier = Modifier
        .size(100.dp)
        .padding(all = 10.dp))
}
@Composable
fun MessageCard(message: Message){
    Row {
        ImageCard(resId = R.drawable.scenary )
        Column {
            Text(text = message.author)
            Text(text = message.message)

        }
    }
}
@Composable
fun Conversation(messages: List<Message>){
    LazyColumn{
       items(messages){ message ->
           MessageCard(message = message)
       }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultView() {
    ComposeTrialTheme {
          Conversation(messages = SampleData.conversationSample)
        }
}