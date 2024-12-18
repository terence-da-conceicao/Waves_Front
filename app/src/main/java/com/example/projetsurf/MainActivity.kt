package com.example.projetsurf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetsurf.ui.theme.ProjetSurfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //base visuelle de l'app (activité) : ProjetSurfTheme
            ProjetSurfTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    //image de fond
                    Image(
                        modifier = Modifier
                            .matchParentSize(),
                        painter = painterResource(id = R.drawable.sand_back),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Image de fond"
                    )
                    CardSpot(theSpot)
                }
            }
        }
    }
}




data class InfosSpot(val nom: String, val lieu: String)

val theSpot = InfosSpot("Bells Beach", "Australie")


// fragment : le spot
@Composable
fun CardSpot(spot: InfosSpot) {
    Surface(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp),
           // .padding(20.dp),
        color = Color(0xFFA1E2EB),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 10.dp),
                text = spot.nom,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium,
                //verticalArrangement = Arrangement.Center,
               // horizontalAlignment = Alignment.CenterHorizontally
            )
            Image(
                painter = painterResource(id = R.drawable.bellsbeach),
                contentDescription = "photo du lieu"
            )
            Text(
                modifier = Modifier
                    .padding(all = 10.dp),
                text = spot.lieu,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
    fun ProjetSurfTheme() {
        CardSpot(theSpot)
   }

