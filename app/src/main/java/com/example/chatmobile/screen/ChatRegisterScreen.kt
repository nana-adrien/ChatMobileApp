package com.example.chatmobile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.AnnotatedString.Builder
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatmobile.R

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun ChatRegisterScreen() {
   val mobileWidth = LocalConfiguration.current.screenWidthDp

   Scaffold(
      containerColor = Color.Blue ,
      topBar = {
         TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.Blue) ,
            title = {} ,
            navigationIcon = {
               IconButton(onClick = {}) {
                  Icon(
                     imageVector = Icons.Default.ArrowBack ,
                     contentDescription = ""
                  )
               }
            }
         )
      }
   )
   {
      Column(
         modifier = Modifier
            .padding(it)
            .fillMaxSize() ,
         horizontalAlignment = Alignment.CenterHorizontally ,
      ) {
         Box(
            contentAlignment = Alignment.Center ,
            modifier = Modifier
               .fillMaxSize()
               .weight(1.4f)
               .background(Color.Transparent) ,

            ) {
            Image(
               modifier = Modifier.size((mobileWidth / 2).dp) ,
               painter = painterResource(R.drawable.baseline_emoji_emotions_24) ,
               contentDescription = ""
            )
         }
         Column(
            modifier = Modifier
               .fillMaxSize()
               .weight(3f)
               .clip(shape = RoundedCornerShape(topStart = 47.dp , topEnd = 47.dp))
               .background(
                  Color(
                     239 ,
                     244 ,
                     245 ,
                     255
                  )
               )
         ) {
            Column(
               modifier = Modifier
                  .fillMaxSize()
                  .weight(0.5f)
                  .background(Color.Green)
            ) {

            }
            Column(
               modifier = Modifier
                  .fillMaxSize()
                  .weight(3f)
                  .shadow(
                     elevation = 2.dp ,
                     shape = RoundedCornerShape(topStart = 40.dp , topEnd = 40.dp)
                  )
                  .background(Color.White)
            ) {
               Column(
                  modifier = Modifier
                     .padding(top = 20.dp)
                     .fillMaxSize()
                     .background(Color.Red)
               ) {

               }
            }
         }
         /* Text("Enregistrer votre nom pour participer au chat")
          TextField(
             value = "",
             placeholder = { Text("Entre ton nom")},
             onValueChange = {},
          )

          Button(onClick = {

          }){
             Text("rejoindre le chat")
          }*/
      }
   }
}

//@Preview(showSystemUi = true)
@Composable
fun LogoButton() {
   Box(
      modifier = Modifier.fillMaxSize() ,
      contentAlignment = Alignment.Center ,
   ) {
      OutlinedIconButton(
         modifier = Modifier.size(45.dp) ,
         onClick = {}) {
         Icon(
            painter = painterResource(R.drawable.baseline_emoji_emotions_24) ,
            contentDescription = ""
         )
      }
   }
}

//@Preview(showSystemUi = true)
@Composable
fun AppTextField() {
   Box(
      modifier = Modifier.fillMaxSize() ,
      contentAlignment = Alignment.Center ,
   ) {
      OutlinedTextField(
         label = { Text(text = "Email") } ,
         value = "name@ " ,
         onValueChange = {}
      )
   }

}

//@Preview(showSystemUi = true)
@Composable
fun AppButton() {
   Box(
      modifier = Modifier.fillMaxSize() ,
      contentAlignment = Alignment.Center ,
   ) {
      Row(modifier = Modifier.fillMaxWidth()) {
         Button(
            modifier = Modifier.fillMaxWidth() ,
            onClick = {}
         ) {
            Text(
               modifier = Modifier.padding(10.dp) ,
               text = "button"
            )
         }
      }

   }

}

//@Preview(showSystemUi = true)
@Composable
fun AppSwitchButton() {
   Box(
      modifier = Modifier.fillMaxSize() ,
      contentAlignment = Alignment.Center ,
   ) {
      val color = Color(
         239 ,
         244 ,
         245 ,
         255
      )
      Row(
         modifier = Modifier ,
         horizontalArrangement = Arrangement.spacedBy(15.dp) ,
         verticalAlignment = Alignment.CenterVertically
      ) {
         Switch(
            colors = SwitchDefaults.colors()
               .copy(
                  disabledCheckedTrackColor = color ,
                  disabledCheckedThumbColor = color ,
                  disabledCheckedBorderColor = color ,
                  checkedThumbColor = Color.Green ,
                  checkedTrackColor = color
               ) ,
            checked = true , onCheckedChange = {})
         Text(
            text = "Remember me" ,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp)
         )
      }
   }

}

@Preview(showSystemUi = true)
@Composable
fun AppparagrapheButton() {
   Box(
      modifier = Modifier.fillMaxSize() ,
      contentAlignment = Alignment.Center ,
   ) {
      ClickableColoredText()
   }
}

@Composable
fun ClickableColoredText() {
   // Construire une chaîne annotée
   val text = "*[bonjour]* */le/* monde android"
   val textTable = text.split(" ")

   // val annotationText=

   /*  Column {
        for (i in textTable){
           var text=i
           if (i.first() == '*' && i.last() == '*'){
              text=i.substring(1,i.lastIndex)
           }
           Text( text="$text")
        }
        Text( text="${textTable.size}")
     }
*/


   val annotatedString = buildAnnotatedString {
      val text = "bonjour *[#bonjour le monde#]* des devs *[#bonjour le monde#]* des devs *[#bonjour le monde#]* des devs"
      //val text ="*[#bonjour le monde#]*"
      val pattern = Regex("([*\\[#%].+[\\]#%*])|([^*\\[#%]+(?:\\s+[^*\\[#%]+)*)")
      val matches = pattern.split(text) //findAll()
      //val result =  matches.map { it.value.trim() }.toList()
      for (match in matches) {
         val segment = match//.value
         //if (segment.matches(Regex("[*\\[#%].+[\\]#%*]"))) {
            customStyleText(
               text = segment ,
               startChar = '*' ,
               endChar = '*'
            ) {
               // append(it)
               append(" $it ")
            }
       //  }
      }

    /*  for (i in result) {
         customStyleText(
            text = i ,
            startChar = '*' ,
            endChar = '*'
         ) {
           // append(it)
            append(" $it ")
         }
      }*/

      customStyleText(
         text = text ,
         startChar = '*' ,
         endChar = '*'
      ) {
        // append( "{${result}}")
      }



      pushStringAnnotation(
         tag = "TAG" ,
         annotation = "modifier_couleur"
      )/*
      withStyle(
         style = androidx.compose.ui.text.SpanStyle(
            color = Color.Blue,
            fontSize = 16.sp,
            textDecoration = TextDecoration.Underline
         )
      ) {
         append("your")
      }*/
      pop()
      // append("${result}  pour changer sa couleur.")
   }


   fun recusive() : String {
      val text = ""
      var newText = ""
      if (text.first().equals("*") && text.last().equals("*")) {
         newText = text.substring(1 , text.lastIndex)
      }
      return text
   }

   // Composant ClickableText

   /* Text(annotatedString)*/
   ClickableText(
      text = annotatedString ,
      onClick = { offset ->
         annotatedString.getStringAnnotations("TAG" , offset , offset)
            .firstOrNull()?.let { annotation ->
               if (annotation.item == "modifier_couleur") {
                  //Logique pour changer la couleur ou autre action

                  println("Texte cliqué : ${annotation.item}")
               }
            }
      }
   )
}


fun <R : Any> Builder.customStyleText(
        text : String ,
        startChar : Char ,
        endChar : Char ,
        annotation : String = "modifier_couleur" ,
        block : AnnotatedString.Builder.(String) -> R ,
) : R {
   var newText = ""
   var style : SpanStyle = SpanStyle()
   val pair = appliquerStyle(text) //CustomStyleTextS(text , startChar , endChar , newText , style)
   newText = pair.first
   style = pair.second
   pushStringAnnotation(
      tag = "TAG_$annotation" ,
      annotation = annotation
   )
   withStyle(
      style = style
   ) {
      return block(newText)
   }
}

private fun CustomStyleTextS(
        text : String ,
        startChar : Char ,
        endChar : Char ,
        newText : String ,
        style : SpanStyle ,
) : Pair<String , SpanStyle> {
   var newText1 = newText
   var style1 = style
   var pair = Pair(newText1 , style1)

   val startCharkey = listOf('*' , '[' , '%' , '#')
   val endCharkey = listOf('*' , ']' , '%' , '#')
   for (i in 1..startCharkey.size) {
      if (text.first().equals(startCharkey[i]) && text.last().equals(endCharkey[i])) {
         newText1 = text.substring(1 , text.lastIndex)
         style1 = when (startCharkey[i]) {
            '*' -> style1.copy(fontWeight = FontWeight.Bold)
            '[' -> style1.copy()
            '%' -> style1.copy(textDecoration = TextDecoration.Underline)
            '#' -> style1.copy(color = Color.Red)
            else -> style1
         }
         break
      }
   }


   /*if (text.first().equals(startChar) && text.last().equals(endChar)) {
      newText1 = text.substring(1 , text.lastIndex)
      style1 = style1.copy()
   }*/
   return pair
}

fun appliquerStyle(text : String) : Pair<String , SpanStyle> {
   val startCharkey = listOf('*' , '[' , '%' , '#')
   val endCharkey = listOf('*' , ']' , '%' , '#')

   for (i in startCharkey.indices) {
      if (text.startsWith(startCharkey[i]) && text.endsWith(endCharkey[i])) {
         val innerText = text.substring(1 , text.length - 1)
         val (newText , innerStyle) = appliquerStyle(innerText)  // Appel récursif

         val style = when (startCharkey[i]) {
            '*' -> innerStyle.copy(fontWeight = FontWeight.Bold)
            '[' -> innerStyle
            '%' -> innerStyle.copy(textDecoration = TextDecoration.Underline)
            '#' -> innerStyle.copy(color = Color.Red)
            else -> innerStyle
         }
         return newText to style
      }
   }
   return text to SpanStyle() // Retourne le texte d'origine avec le style par défaut si aucune paire ne correspond
}
