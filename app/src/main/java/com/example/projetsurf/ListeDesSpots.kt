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

@Composable
fun DisplayListSpots() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonSpot(image = painterResource(id = R.drawable.vague), surfBreak = "Spot 1", location = "Lieu 1")
            ButtonSpot(image = painterResource(id = R.drawable.couple_surf), surfBreak = "Spot 2", location = "Lieu 2")
            ButtonSpot(image = painterResource(id = R.drawable.plage_ecume), surfBreak = "Spot 3", location = "Lieu 3")
            ButtonSpot(image = painterResource(id = R.drawable.bellsbeach), surfBreak = "Spot 4", location = "Lieu 4")
        }
    }
}

@Composable
fun ButtonSpot(
    image: Painter, // Image pour l'arrière-plan
    surfBreak: String, // Texte principal
    location: String // Texte secondaire
) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .width(300.dp)
            .padding(bottom = 20.dp) // Espacement entre les boutons
            .clickable { /* Action à effectuer lors du clic */ }, // Rendre le bouton cliquable
        contentAlignment = Alignment.Center // Centre le contenu dans le bouton
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
fun ButtonHome() {
    Box(
        modifier = Modifier
            .height(80.dp)
            .width(140.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { /* Action du bouton */ },
        contentAlignment = Alignment.Center
    ) {
        Surface(color = Color(0xFF08c9c8)) {
            Text(
                text = "Accueil",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                //modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
@Preview
fun PreviewButtonSpot() {
    ButtonSpot(
        image = painterResource(id = R.drawable.vague),
        surfBreak = "Spot Test",
        location = "Lieu Test"
    )
}

@Composable
@Preview
fun PreviewDisplayListSpots() {
    DisplayListSpots()
}
