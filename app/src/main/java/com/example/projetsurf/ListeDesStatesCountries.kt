package com.example.projetsurf

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun DisplayListStatesCountries(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonStateCountry(navController)
            ButtonStateCountry(navController)
            ButtonStateCountry(navController)
            ButtonStateCountry(navController)



        }
    }
}

@Composable
fun ButtonStateCountry(navController: NavController){
    Button(
        modifier = Modifier.height(80.dp).width(300.dp),
        shape = RoundedCornerShape(10.dp),
        enabled = true,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF08c9c8)),
        onClick = { navController.navigate(Router.ListeSpots.name) }
    ) {
        Text(
            text = "Pays",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}




@Composable
@Preview
fun PreviewButtonStateCountry(){
    val navController = rememberNavController()
    ButtonStateCountry(navController)
}

@Composable
@Preview
fun PreviewDisplayListStatesCountries() {
    val navController = rememberNavController()
    DisplayListStatesCountries(navController)
}