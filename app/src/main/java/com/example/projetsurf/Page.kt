package com.example.projetsurf

sealed class Page {
    object ChosenSpot : Page()
    object ListOfSpots : Page()
//    object ListOfCountries : Page()
}