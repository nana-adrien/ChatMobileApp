package com.example.chatmobile

import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.*
import io.ktor.websocket.*
import kotlinx.coroutines.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class WebSocketViewModel : ViewModel() {
   private val client = HttpClient() {
      install(WebSockets)
   }

   // Fonction pour se connecter au serveur WebSocket
   fun connectWebSocket() {
      viewModelScope.launch {
         client.webSocket("ws://192.168.100.17/websocket") {
            send("Hello WebSocket") // Envoi d'un message de bienvenue

            // Ecoute des messages entrants
            for (message in incoming) {
               when (message) {
                  is Frame.Text -> {
                     println("Message reçu : ${message.readText()}")
                  }

                  else -> {}
               }
            }
         }
      }
   }

   // Fonction pour envoyer un message au serveur WebSocket
   fun sendMessage(message: String) {
      viewModelScope.launch {
         client.webSocket("ws://192.168.100.17/websocket") {
            send(message) // Envoi du message
         }
      }
   }

   override fun onCleared() {
      super.onCleared()
      client.close() // Fermer le client lors de la destruction du ViewModel
   }
}
