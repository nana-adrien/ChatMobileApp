package com.example.chatmobile.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UsernameScreen(onUsernameEntered: (String) -> Unit) {
   var username by remember { mutableStateOf("") }

   Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
   ) {
      TextField(
         value = username,
         onValueChange = { username = it },
         label = { Text("Entrez votre nom") }
      )
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { if (username.isNotEmpty()) onUsernameEntered(username) }) {
         Text("Se connecter")
      }
   }
}

