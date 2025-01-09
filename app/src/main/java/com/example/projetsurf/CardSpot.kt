package com.example.projetsurf

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.google.gson.annotations.SerializedName


data class InfosSpot(
    @SerializedName("Surf Break")
    val surfBreak: String,
    val Photos: String,
    val Address: String
)

//val theSpot = InfosSpot("Bells Beach", "Australie")

@Composable
fun DisplaySpot(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column()
        {
            CardSpot(navController)
            ShowButtons(navController)
        }
    }
}


/*L'encart horizontal qui contient les deux boutons */
@Composable
fun ShowButtons(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(140.dp),
            shape = RoundedCornerShape(10.dp),
            enabled = true,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF08c9c8),
                contentColor = Color.Black
            ),
            onClick = { navController.navigate(Router.ListeSpots.name) }
        ) {
            Text(
                text = "Liste des spots",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(150.dp),
            shape = RoundedCornerShape(10.dp),
            enabled = true,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF08c9c8),
                contentColor = Color.Black
            ),
            onClick = { navController.navigate(Router.ListePays.name) }
        ) {
            Text(
                text = "Accueil",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

} /*Button */
} /* Row */
} /* ShowButtons */



@Composable
fun CardSpot(navController: NavController) {
    Surface(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp),
        color = Color(0xFFA1E2EB),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val spots = spotList(context = LocalContext.current)
            spots.firstOrNull()?.let { spot ->
                Text(
                    modifier = Modifier.padding(all = 10.dp),
                    text = spot.surfBreak,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                )
                AsyncImage(
                    model = "https://media.istockphoto.com/id/816752606/fr/photo/carte-de-test-tv-ou-mire-g%C3%A9n%C3%A9rique.jpg?s=612x612&w=0&k=20&c=nraCmqihb_FNDhPfxFGRB4jabgrEtVJy0m6xL_UJTcM=",
                    contentDescription = "photo du lieu"
                )
                Text(
                    modifier = Modifier.padding(all = 10.dp),
                    text = spot.Address,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium
                )
                Log.d("fetched url", spot.Photos) //log de l'url de l'image dans le json
            } ?: Text("No spots available")
        }/* Column */
    } /* Surface */
} /*CardSpot*/


@Preview(showBackground = true)
@Composable
fun PreviewShowButtons() {
    val navController = rememberNavController()
    ShowButtons(navController = rememberNavController())
}


@Preview(showBackground = true)
@Composable
fun PreviewCardSpot() {
    val navController = rememberNavController()
    CardSpot(navController = rememberNavController())
}


@Preview(showBackground = true)
@Composable
fun PreviewDisplaySpot() {
    val navController = rememberNavController()
    DisplaySpot(navController = rememberNavController())
}