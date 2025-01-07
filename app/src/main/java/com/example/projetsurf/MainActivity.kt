package com.example.projetsurf

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetsurf.CardSpot
import com.example.projetsurf.ui.theme.ProjetSurfTheme
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
//        Log.d("test-log", "onCreate called")
        setContent {
            ProjetSurfTheme()
        }
//        logMessage()
    }
}


@Composable
fun ProjetSurfTheme () {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.sand_back),
            contentDescription = "Image de fond",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
                DisplaySpot()
                DisplayListSpots()


        }
    }
}



//fonction pour convertir le json en string
fun loadSpotFromAssets(context: Context, fileName: String
): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exp: IOException) {
        exp.printStackTrace()
        return null
    }
    return jsonString
}

//fun logMessage() {
//    val thtjson: String =
//    Log.d("msg console", "message : $thtjson")
//}


// 'fetch" le json depuis fichier local ('assets')
fun spotList(context: Context): List<InfosSpot> {
    return try {
        val jsonFileString = loadSpotFromAssets(context, "first.json")
            ?: return emptyList()

        // Parse the wrapper object first, then get the records list
        val type = object : TypeToken<SpotResponse>() {}.type
        val response = Gson().fromJson<SpotResponse>(jsonFileString, type)
        /*
        val type contient un type. En effet, quand on parse avec Gson(), il y a une tendance
        à perdre de la donnée, donc on crée un type. Ce type va être conceptualisé comme un objet,
        et on va calquer son identité sur la classe SpotResponse.

        response est une variable dont le contenu est ce qui converti depuis jsonFileString (qui est unn json/une string) grâce
        à Gson() et qui devient un objet de type type, donc de type SpotResponse.
        En d'autres termes, response, c'est un objet contenant une variable records, qui contient
        une liste, qui contient des instances de la classe InfosSpot, donc des objets avec les infos
        des spots de surf.
        */

        // Return the records list, or empty list if null
        response?.records ?: emptyList()
    } catch (e: Exception) {
        Log.e("SpotList", "Error parsing JSON", e)
        emptyList() // Return empty list on any error
    }
}



//transforme la string en liste
data class SpotResponse(
    val records: List<InfosSpot>
)









@Preview(showBackground = true)
@Composable
fun PreviewProjetSurfTheme() {
    ProjetSurfTheme()
}
