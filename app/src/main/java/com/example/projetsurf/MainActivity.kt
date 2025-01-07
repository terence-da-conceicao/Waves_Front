package com.example.projetsurf

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ProjetSurfTheme()
        }
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


// 'fetch" le json depuis fichier local ('assets')
fun spotList(context: Context): List<InfosSpot> {
    return try {
        val jsonFileString = loadSpotFromAssets(context, "first.json")
            ?: return emptyList()

        // Parse the wrapper object first, then get the records list
        val type = object : TypeToken<SpotResponse>() {}.type
        val response = Gson().fromJson<SpotResponse>(jsonFileString, type)

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
