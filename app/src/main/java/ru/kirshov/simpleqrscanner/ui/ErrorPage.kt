package ru.kirshov.simpleqrscanner.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorPage(){
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Permission not")
    }
}