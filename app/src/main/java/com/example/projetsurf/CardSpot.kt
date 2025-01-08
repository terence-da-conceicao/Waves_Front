package com.example.projetsurf

import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.google.gson.annotations.SerializedName


//récupère les différents éléments de la liste
data class InfosSpot(
@SerializedName("Surf Break") /*à utiliser pour modifier le nom du champs du json (par exemple
    si il y a un espace dans la clé*/
val surfBreak: String,
val Photos: String,
val Address: String
)



//val theSpot = InfosSpot("Bells Beach", "Australie")

/* la fonction qui rassemble les elements de la page entière : l'encart avec les infos du spot et l'encart avec les deux boutons */
@Composable
fun DisplaySpot() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column()
        {
//            CardSpot(theSpot)
            CardSpot()
            ShowButtons()
        }
    }
}


/*L'encart horizontal qui contient les deux boutons */
@Composable
fun ShowButtons() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            /*bouton liste des spots*/
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(10.dp),
                enabled = true,
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF08c9c8),
                    contentColor = Color.Black),
                onClick = { }
            ) {
                Text(
                    text = "Revenir à la liste des spots de ce pays",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

            } /*Button */

            /*bouton accueil */
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(10.dp),
                enabled = true,
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF08c9c8),
                    contentColor = Color.Black
                ),
                onClick = { /* ECRIRE CE QUE FAIT LE BOUTON viewModel.fonction*/ }
            ) {
                Text(
                    text = "Accueil",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

            } /*Button */
        } /* Row */
} /* ShowButtons */



/* encart avec les infos du spot */
@Composable
//fun CardSpot(spot: InfosSpot)
fun CardSpot() {
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
            /*on place dans la variable spots le contenu de la fonction spotList, qui créé
            un objet contenant une variable records, qui contient
            une liste, qui contient des instances de la classe InfosSpot, donc des objets avec les infos
            des spots de surf.
            On vérifie si le contenu de spots est vide, puis s'il ne l'et pas, on affiche
            le premier element et on l'assigne dans la variable spot.
            Enfin, on appele les infos de spot isolément.
            */
            val spots = spotList(context = LocalContext.current)
            spots.firstOrNull()?.let { spot ->
                Text(
                    modifier = Modifier
                        .padding(all = 10.dp),
                    text = spot.surfBreak,
                    //affichage nom du spot
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                )
                AsyncImage(
                    model = "https://media.istockphoto.com/id/816752606/fr/photo/carte-de-test-tv-ou-mire-g%C3%A9n%C3%A9rique.jpg?s=612x612&w=0&k=20&c=nraCmqihb_FNDhPfxFGRB4jabgrEtVJy0m6xL_UJTcM=",
                    contentDescription = "photo du lieu"
                )
                Text(
                    modifier = Modifier
                        .padding(all = 10.dp),
                    text = spot.Address,
                    //affichage lieu du spot
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium
                )
                Log.d("fetched url", spot.Photos) //log de l'url de l'image dans le json
            }?: Text("No spots available")
        }/* Column */
    } /* Surface */
} /*CardSpot*/






@Preview(showBackground = true)
@Composable
fun PreviewShowButtons() {
    ShowButtons()
}


@Preview(showBackground = true)
@Composable
fun PreviewCardSpot() {
//    CardSpot(theSpot)
    CardSpot()
}


@Preview (showBackground = true)
@Composable
fun PreviewDisplaySpot() {
    DisplaySpot()
}