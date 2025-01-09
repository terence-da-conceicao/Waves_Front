package com.example.projetsurf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projetsurf.ui.theme.ProjetSurfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetSurfTheme() {
                ProjetSurfApp()
            }
        }
    }
}