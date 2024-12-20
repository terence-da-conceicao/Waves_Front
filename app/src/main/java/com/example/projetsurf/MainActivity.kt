package com.example.projetsurf

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.projetsurf.ui.theme.ProjetSurfTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           ProjetSurfTheme {
                    Surface (modifier = Modifier.fillMaxSize(),
                        )
                    {
                        OneSpotScreen ()
                    }
                }
            }
        }
    }

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

fun spotList(context: Context): List<Spot> {
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

data class SpotResponse(
    val records: List<Spot>
)

data class Spot(
    val `Surf Break`: String,
    val Photos: Int,
    val Address: String
)

@Composable
fun OneSpotScreen () {
        Box(modifier = Modifier.fillMaxSize()) {
        Image (
            painter = painterResource(id = R.drawable.sand_back),
            contentDescription  = "Sandy background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column  (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val spots = spotList(context = LocalContext.current)
            spots.firstOrNull()?.let { spot ->
                Text(text = spot.`Surf Break`, fontSize = 30.sp, fontWeight = FontWeight.Medium)
                Image(painter = painterResource(id = R.drawable.test_default),
                contentDescription  = "Image placeholder",)
                Text(text = spot.Address, fontSize = 30.sp, fontWeight = FontWeight.Medium)
            } ?: Text("No spots available")
        }
        }

    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetSurfTheme {
        OneSpotScreen()
    }
}