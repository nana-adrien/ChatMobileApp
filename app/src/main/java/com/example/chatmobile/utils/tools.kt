package com.example.chatmobile.utils

import android.graphics.Color
import kotlin.math.abs

object Tools {
   fun getAvatarColor(userName : String) : Int {
      var hash=0
      val colors = listOf("#A1F2C4","#37BC84" , "#E89C56" , "#4F28FF" ,
         "#9D00E3" , "#00FAAA" , "#145B7F" , " #EFC3DD" , "#AC4723" , "#003CFF")
      for (counter in 0..userName.length){
         hash=31*hash+userName.codePointAt(counter)
      }
      val index= abs(hash % colors.size)
      return  Color.parseColor(colors[index].toString())
   }
}