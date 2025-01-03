package com.example.chatmobile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import okhttp3.*
import okio.ByteString
import java.util.concurrent.TimeUnit


class ChatViewModel2 : ViewModel() {
   private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
   val messages = _messages.asStateFlow()

   private var webSocket: WebSocket? = null
   private val client = OkHttpClient.Builder()
      .readTimeout(3, TimeUnit.SECONDS)
      .build()

   fun connect(username: String) {
      val request = Request.Builder()
         .url("ws://192.168.100.17:8080/websocket")
         .build()

      webSocket = client.newWebSocket(request, object : WebSocketListener() {
         override fun onOpen(webSocket: WebSocket, response: Response) {
            // Envoyer un message d'inscription
            val registerMessage = "{\"sender\":\"$username\",\"type\":\"JOIN\"}"
            webSocket.send(registerMessage)
         }

         override fun onMessage(webSocket: WebSocket, text: String) {
            _messages.value += Gson().fromJson(text , ChatMessage::class.java)
         }

         override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
          //  _messages.value = _messages.value + bytes.utf8()
            Log.i("info","onMessage $bytes")
         }

         override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            Log.e("error",  "Erreur de connexion : ${t.message}")
         }

         override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            webSocket.close(1000, null)
            Log.i("error", "Connexion fermée : $reason")

            //_messages.value = _messages.value + "Connexion fermée : $reason"
         }
      })
   }

   fun sendMessage(chatMessage : ChatMessage) {
      val message = "{\"content\":\"${chatMessage.content}\",\"sender\":\"${chatMessage.sender}\",\"type\":\"CHAT\"}"
      webSocket?.send(message)
      _messages.value+=chatMessage
   }

   override fun onCleared() {
      super.onCleared()
      webSocket?.close(1000, "ViewModel cleared")
   }
}


data class ChatMessage(
        val sender: String,
        val type: String, // "JOIN", "CHAT", "LEAVE"
        val content: String
) {
   fun toJson(): String {
      // Convertir en JSON
      return Gson().toJson(this)
   }
}
