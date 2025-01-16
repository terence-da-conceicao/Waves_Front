package com.example.projetsurf

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DisplayListSpots(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonHome(navController)
            ButtonSpot(navController, image = painterResource(id = R.drawable.vague), surfBreak = "Spot 1", location = "Lieu 1")
            ButtonSpot(navController, image = painterResource(id = R.drawable.couple_surf), surfBreak = "Spot 2", location = "Lieu 2")
            ButtonSpot(navController, image = painterResource(id = R.drawable.plage_ecume), surfBreak = "Spot 3", location = "Lieu 3")
            ButtonSpot(navController, image = painterResource(id = R.drawable.bellsbeach), surfBreak = "Spot 4", location = "Lieu 4")
        }
    }
}

@Composable
fun ButtonSpot(
    navController: NavController,
    image: Painter, // Image pour l'arrière-plan
    surfBreak: String, // Texte principal
    location: String // Texte secondaire
) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(300.dp)
            .padding(bottom = 30.dp) // Espacement entre les boutons
            .clickable { navController.navigate(Router.Spot.name) }, // Navigation au clic
        contentAlignment = Alignment.Center // Centre le contenu
    ) {
        // Image en arrière-plan
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)), // Coins arrondis
            contentScale = ContentScale.Crop // Adapte l'image à la taille du bouton
        )

        // Texte superposé
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = surfBreak,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White, // Couleur du texte principal
                textAlign = TextAlign.Center
            )
            Text(
                text = location,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = Color.White, // Couleur du texte secondaire
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ButtonHome(navController: NavController) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .width(150.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { navController.navigate(Router.ListePays.name) }, // Navigation
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = Color(0xFF08c9c8),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Accueil",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewButtonSpot() {
    ButtonSpot(
        navController = rememberNavController(),
        image = painterResource(id = R.drawable.vague),
        surfBreak = "Spot Test",
        location = "Lieu Test"
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewButtonHome() {
    ButtonHome(navController = rememberNavController())
}

@Composable
@Preview(showBackground = true)
fun PreviewDisplayListSpots() {
    DisplayListSpots(navController = rememberNavController())
}
