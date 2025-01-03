package com.example.chatmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatmobile.ui.theme.ChatMobileTheme

class MainActivity : ComponentActivity() {
   private val webSocketClient = WebSocketClient()
   override fun onCreate(savedInstanceState : Bundle?) {
      super.onCreate(savedInstanceState)
      enableEdgeToEdge()
      setContent {
         ChatMobileTheme {
          //  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
               ChatApp()
           // }
         }
      }
   }
   override fun onDestroy() {
      super.onDestroy()
      webSocketClient.disconnect()
   }
}

@Composable
fun Greeting(name : String , modifier : Modifier = Modifier) {
   Text(
      text = "Hello $name!" ,
      modifier = modifier
   )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   ChatMobileTheme {
      Greeting("Android")
   }
}