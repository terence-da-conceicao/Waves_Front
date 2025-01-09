package com.example.projetsurf

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun DisplayListSpots(navController: NavController)
    {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonHome(navController)
            ButtonSpot(navController)
            ButtonSpot(navController)
            ButtonSpot(navController)
            ButtonSpot(navController)
        }

    }
}

@Composable
fun ButtonSpot(navController: NavController){
    Button(
        modifier = Modifier
            .height(80.dp)
            .width(300.dp),
        shape = RoundedCornerShape(10.dp), //bords arrondis
        enabled = true, //ça le rend cliquable
        elevation = ButtonDefaults.buttonElevation(
        defaultElevation = 20.dp, /*aucune idée de ce que ça fait, lui donner une ombre portée? ça n'a pas marché si c'est le cas*/ ),
        colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF08c9c8), //couleur du fond (j'ai laissé en bleu mais il faut mettre une image)
        contentColor = Color.Black /* couleur du contennu (ici le texte) */ ),
        onClick = { navController.navigate(Router.Spot.name) }
        ) {
        Text(
            text = "Nom (Surf Break)",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = "Lieu (State/Country)",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun ButtonHome(navController: NavController) {
    Button(
        modifier = Modifier
            .height(80.dp)
            .width(140.dp),
        shape = RoundedCornerShape(10.dp),
        enabled = true,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF08c9c8), contentColor = Color.Black),
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







@Composable
@Preview
fun PreviewButtonSpot(){
    ButtonSpot(navController = rememberNavController())
}

@Composable
@Preview
fun PreviewButtonHome(){
    ButtonHome(navController = rememberNavController())
}

@Composable
@Preview
fun PreviewDisplayListSpots(){
  DisplayListSpots(navController = rememberNavController())
}

