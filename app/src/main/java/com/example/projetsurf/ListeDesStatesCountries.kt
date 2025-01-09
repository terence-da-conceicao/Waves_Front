package com.example.projetsurf

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResources
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DisplayListStatesCountries(){
    Surface(
        color = Color.Red,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonStateCountry( )
            ButtonStateCountry()
            ButtonStateCountry()
            ButtonStateCountry()



        }
    }
}

@Composable
fun ButtonStateCountry(
    //image: Pointer, // Image arrière plan
    //text: Sting // Texte superposé
){
    Button(
        modifier = Modifier
            .height(150.dp)
            .width(300.dp)
            .padding(bottom = 40.dp),
        shape = RoundedCornerShape(10.dp), //bords arrondis
        enabled = true, //ça le rend cliquable
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 20.dp, /*aucune idée de ce que ça fait, lui donner une ombre portée? ça n'a pas marché si c'est le cas*/ ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF08c9c8), //couleur du fond (j'ai laissé en bleu mais il faut mettre une image)
            contentColor = Color.Black /* couleur du contennu (ici le texte) */ ),
        onClick = { /* ECRIRE CE QUE FAIT LE BOUTON viewModel.fonction*/ }
    ) {
        Text(
            text = "Pays",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

    } /*Button */

}




@Composable
@Preview
fun PreviewButtonStateCountry(){
    ButtonStateCountry()
}

@Composable
@Preview
fun PreviewDisplayListStatesCountries() {
    DisplayListStatesCountries()
}