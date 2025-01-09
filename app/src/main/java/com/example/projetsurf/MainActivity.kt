package com.example.projetsurf

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Navigation()
            ProjetSurfTheme()
        }
    }
}

enum class Router() {
    ListePays,
    ListeSpots,
    Spot
}

@Composable
fun ProjetSurfTheme () {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Router.ListePays.name,
        modifier = Modifier.padding(20.dp)
    ) {
        composable(route = Router.ListePays.name) {
            DisplayListStatesCountries(navController)
        }
        composable(route = Router.ListeSpots.name) {
            DisplayListSpots(navController)
        }
        composable(route = Router.Spot.name) {
            DisplaySpot(navController)
        }
    }
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
            DisplayListStatesCountries(navController)

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
