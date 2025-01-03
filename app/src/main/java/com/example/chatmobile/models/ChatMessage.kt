package com.example.chatmobile.models

data class ChatMessage(
        val content : String ,
        val sender : String ,
        val messageType : MessageType ,
        val time : String ,
)
 enum class MessageType {
   CHAT , // for normal message
   JOIN , // FOR WHEN A USER JOINS THE CHAT
   LEAVE // for when a user leaver the chat
}
