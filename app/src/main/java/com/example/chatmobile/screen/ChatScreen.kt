import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatmobile.R
import com.example.chatmobile.models.ChatMessage
import com.example.chatmobile.models.MessageType
import java.util.Date

@Preview(showSystemUi = true)
@Composable
fun ChatScreen() {
   val messages = listOf<ChatMessage>(
      ChatMessage(
         content = "@Vous avez creer le chat" ,
         sender = "yy" ,
         messageType = MessageType.JOIN ,
         time = Date().toString()
      ),
      ChatMessage(
         content = "La Chanson ci c’est la magie je l écoute depuis 3 semaines non stop \uD83D\uDE02la version de rentamplàn alors c’est la mort seulement très belle chanson merci AXEL  et son groupe \uD83D\uDE02\uD83C\uDDE8\uD83C\uDDF2\uD83D\uDE4F" ,
         sender = "erick" ,
         messageType = MessageType.CHAT ,
         time = Date().toString()
      ) ,
      ChatMessage(
         content = "@yy a rejoint le chat " ,
         sender = "yy" ,
         messageType = MessageType.JOIN ,
         time = Date().toString()
      ),
      ChatMessage(
         content = "Je valide , je valide ce la magie cette musique. Je Viens de découvrir cette musique depuis la France . J’aime mon pays" ,
         sender = "yy" ,
         messageType = MessageType.CHAT ,
         time = Date().toString()
      ),
      ChatMessage(
         content = "Je valide , je valide ce la magie cette musique. Je Viens de découvrir cette musique depuis la France . J’aime mon pays" ,
         sender = "yy" ,
         messageType = MessageType.CHAT ,
         time = Date().toString()
      ),
      ChatMessage(
         content = "@yy a quitter le chat" ,
         sender = "yy" ,
         messageType = MessageType.LEAVE ,
         time = Date().toString()
      )
   )
   Scaffold(
      modifier = Modifier.fillMaxSize() ,
      topBar = {
         ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.Green.copy(alpha = 0.5f)),
            leadingContent = {
               Row(
                  verticalAlignment = Alignment.CenterVertically
               ){
                  IconButton(onClick = {}) {
                     Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                  }
                  CircularAvatar("Groupe")
               }
            } ,
            headlineContent = {
               Text("groupe Title ")
            } ,
            supportingContent = {
               Text("groupe Description ")
            } ,
            trailingContent = {
               IconButton(onClick = {}) {
                  Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
               }
            }
         )
      } ,
      bottomBar = {
         Box(modifier = Modifier.padding(10.dp)) {
            PrepareMessageBar()
         }
      }
   ) { paddingValue ->
      LazyColumn(
         modifier = Modifier
            .padding(paddingValue)
            .fillMaxSize()
            .padding(10.dp) ,
      ) {
         items(items = messages) {
            if (it.messageType!=MessageType.CHAT ){
               JoinChatMessageBubble(it.content,it.messageType)
            }else{
               ChatScreenItem(it)
            }

         }
      }
   }

}

@Composable
private fun PrepareMessageBar() {
   Row(
      verticalAlignment = Alignment.Bottom ,
      modifier = Modifier
         .fillMaxWidth()
         .padding(bottom = 20.dp)
   ) {
      Column(
         modifier = Modifier
            .weight(5f)
            .shadow(
               elevation = 1.dp ,
               shape = MessageBubbleShape(false)
            )
      ) {
         Row(modifier = Modifier.fillMaxWidth()) {

         }
         Row(
            modifier = Modifier
               .fillMaxWidth()
               .padding(10.dp) ,
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.Bottom
         ) {
            Row(
               modifier = Modifier.weight(0.7f) ,
            ) {
               Icon(
                  painter = painterResource(R.drawable.baseline_emoji_emotions_24) ,
                  contentDescription = ""
               )
            }
            BasicTextField(
               modifier = Modifier
                  .weight(4f)
                  .padding(vertical = 10.dp , horizontal = 5.dp) ,
               value = "jhvjda" ,// "La Chanson ci c’est la magie je l écoute depuis 3 semaines non stop \uD83D\uDE02la version de rentamplàn alors c’est la mort seulement très belle chanson merci AXEL  et son groupe \uD83D\uDE02\uD83C\uDDE8\uD83C\uDDF2\uD83D\uDE4F" ,
               onValueChange = {} ,
            )
            Row(modifier = Modifier.weight(1.5f)) {
               IconButton(
                  modifier = Modifier.weight(1f) ,
                  onClick = {}) {
                  Icon(
                     painter = painterResource(R.drawable.baseline_attach_file_24) ,
                     contentDescription = ""
                  )
               }
               IconButton(
                  modifier = Modifier.weight(1f) ,
                  onClick = {}) {
                  Icon(
                     painter = painterResource(R.drawable.outline_photo_camera_24) ,
                     contentDescription = ""
                  )
               }
            }
         }
      }
      /*
            OutlinedTextField(
               modifier = Modifier.shadow(
                  elevation = 1.dp ,
                  shape = MessageBubbleShape(false)
               ) ,
               value = "" ,
               onValueChange = {} ,
               trailingIcon = {
                  Row {
                     IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.AddCircle , contentDescription = "")
                     }
                     IconButton(onClick = {}) {
                        Icon(
                           painter = painterResource(R.drawable.outline_photo_camera_24) ,
                           contentDescription = ""
                        )
                     }
                  }
               }
            )*/
      Box(
         contentAlignment = Alignment.Center ,
         modifier = Modifier.weight(1f) ,
      ) {
         FloatingActionButton(
            modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize) ,
            shape = CircleShape ,
            onClick = {}) {
            Icon(
               modifier = Modifier.padding(5.dp) ,
               imageVector = Icons.Default.Send , contentDescription = ""
            )
         }
      }

   }
   /*
   ListItem(
      colors = ListItemDefaults.colors(containerColor = Color.Transparent) ,
      leadingContent = { } ,
      headlineContent = {

      } ,
      trailingContent = {

      }
   )*/
}

@Composable
private fun ChatScreenItem(chatMessage : ChatMessage) {

   val width = LocalConfiguration.current.screenWidthDp
   val isSender = chatMessage.sender == "erick"
   Row(
      modifier = Modifier
         .fillMaxWidth()
         .padding(start = if (isSender) 100.dp else 0.dp , end = if (!isSender) 100.dp else 0.dp) ,
      verticalAlignment = Alignment.Top ,
      horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start
   ) {
      /*ListItem(
         colors = ListItemDefaults.colors(containerColor = Color.Transparent) ,
         modifier = Modifier
            .weight(3f)
            .height(250.dp)
            .drawBehind {
               // Dimensions
               val width = size.width - 20
               val height = size.height

               val bubblePath = Path().apply {
                  // Haut-gauche
                  moveTo(50f , 0f)
                  lineTo(width - 50f , 0f) // Bord supérieur
                  quadraticTo(
                     width ,
                     0f ,
                     width + 50 ,
                     0f
                  ) // Coin supérieur droit
                  lineTo(width , height - (height * 0.9).toFloat()) // Bord droit
                  quadraticTo(
                     width - 50 ,
                     height ,
                     width - (height * 0.2).toFloat() ,
                     height
                  ) // Coin inférieur droit

                  // Pointe de la bulle (queue)
                  // lineTo(width / 2 + 20f, height)
                  //lineTo(width / 2, height + 20f)
                  //lineTo(width / 2 - 20f, height)

                  lineTo(50f , height) // Bord inférieur gauche
                  quadraticTo(
                     0f ,
                     height ,
                     0f ,
                     height - 50f
                  ) // Coin inférieur gauche
                  lineTo(0f , 50f) // Bord gauche
                  quadraticTo(
                     0f ,
                     0f ,
                     50f ,
                     0f
                  ) // Coin supérieur gauche
                  close()
               }

               drawPath(
                  path = bubblePath ,
                  color = Color.DarkGray ,
                  //style = Fill
               )
            } ,
         leadingContent = {
         } ,
         headlineContent = { Text(chatMessage.content) } ,
         trailingContent = {

         }
      )*/
         if (!isSender) {
            CircularAvatar(chatMessage.sender)
         }
         MessageBubble(chatMessage.content , isSender)
   }
}

@Composable
private fun CircularAvatar(userName : String) {
   val color = android.graphics.Color.parseColor("#E89C56")//Tools.getAvatarColor(userName)
   Box(
      modifier = Modifier
         .size(30.dp)
         .shadow(elevation = 1.dp , shape = CircleShape)
         .background(Color(color = color)) ,
      contentAlignment = Alignment.Center
   ) { Text(text = userName.uppercase().first().toString() , fontWeight = FontWeight.Bold) }
}


@Composable
fun MessageBubble(content : String , isSent : Boolean) {
   Box(
      modifier = Modifier
         .padding(8.dp)
         .background(
            color = if (isSent) Color.DarkGray else Color.Red ,
            shape = MessageBubbleShape(isSent)
         )
         .padding(16.dp)
   ) {
      Text(
         text = content ,
         color = Color.Black ,
         style = TextStyle(fontSize = 16.sp)
      )
   }
}
@Composable
fun JoinChatMessageBubble(content : String ,messageType: MessageType) {
  Row( modifier=Modifier.padding(horizontal = 80.dp, vertical = 10.dp).fillMaxWidth(),
     verticalAlignment = Alignment.CenterVertically,
     horizontalArrangement = Arrangement.Center){
     Box(
        modifier = Modifier
           .background(
              color = if (messageType==MessageType.LEAVE)Color.Gray.copy(0.5f)else Color.Blue.copy(0.5f) ,
              shape = MessageBubbleShape(false)
           )
           .padding(7.dp)
     ) {
        Text(
           text =" --$content-- ",
           color =if (messageType==MessageType.LEAVE)Color.Gray else Color.White,
           style = TextStyle(fontSize = 12.sp)
        )
     }
  }

}

// Custom Shape for the bubble
fun MessageBubbleShape(isSent : Boolean) = object : Shape {
   override fun createOutline(
           size : Size ,
           layoutDirection : LayoutDirection ,
           density : Density ,
   ) : Outline {
      val path = Path().apply {
         val cornerRadius = 30f // Rayon des coins arrondis
         val pointerWidth = -20f // Largeur de la pointe
         val pointerHeight = 20f // Hauteur de la pointe

         // Coin supérieur gauche
         moveTo(cornerRadius , 0f)

         // Bord supérieur
         if (isSent) {
            lineTo(size.width - pointerWidth , 0f) // Jusqu'à avant la pointe
            lineTo(size.width , pointerHeight) // Pointe supérieure droite
         } else {
            lineTo(size.width , 0f) // Sans pointe
         }

         // Bord droit
         lineTo(size.width , size.height - cornerRadius)
         quadraticTo(
            size.width , size.height ,
            size.width - cornerRadius , size.height
         )

         // Bord inférieur
         lineTo(cornerRadius , size.height)
         quadraticTo(
            0f , size.height ,
            0f , size.height - cornerRadius
         )

         // Bord gauche
         lineTo(0f , cornerRadius)
         quadraticTo(
            0f , 0f ,
            cornerRadius , 0f
         )

         close()
      }
      return Outline.Generic(path)
   }
}

