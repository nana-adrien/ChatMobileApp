package com.example.chatmobile

import okhttp3.*
import okio.ByteString

class WebSocketClient {

   private var webSocket: WebSocket? = null

   fun connect(url: String) {
      val client = OkHttpClient()

      val request = Request.Builder()
         .url(url)
         .build()

      webSocket = client.newWebSocket(request, object : WebSocketListener() {
         override fun onOpen(webSocket: WebSocket, response: Response) {
            super.onOpen(webSocket, response)
            println("WebSocket Connected")
         }

         override fun onMessage(webSocket: WebSocket, text: String) {
            super.onMessage(webSocket, text)
            println("Received: $text")
         }

         override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            super.onMessage(webSocket, bytes)
            println("Received bytes: ${bytes.hex()}")
         }

         override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosing(webSocket, code, reason)
            println("Closing: $reason")
            webSocket.close(1000, null)
         }

         override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosed(webSocket, code, reason)
            println("Closed: $reason")
         }

         override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            super.onFailure(webSocket, t, response)
            println("Error: ${t.message}")
         }
      })
   }

   fun sendMessage(message: String) {
      webSocket?.send(message)
   }

   fun disconnect() {
      webSocket?.close(1000, "Disconnecting")
   }
}
