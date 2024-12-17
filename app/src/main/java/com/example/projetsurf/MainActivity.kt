package com.example.projetsurf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.projetsurf.ui.theme.ProjetSurfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           ProjetSurfTheme {
                    Surface (modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    )
                    {
                        DemoScreen (theSpot)
                    }
                }
            }
        }
    }

data class InfosSpot(val nom: String, val lieu: String)
val theSpot = InfosSpot("Le lac des oiseaux", "Inde")
@Composable
fun DemoScreen (spot:InfosSpot) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image (
            painter = painterResource(id = R.drawable.sand_back),
            contentDescription  = "Demo background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column {
            Text(text = spot.nom)
            Text(text = spot.lieu)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetSurfTheme {
        DemoScreen(theSpot)
    }
}