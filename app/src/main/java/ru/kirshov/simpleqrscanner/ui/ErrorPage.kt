package ru.kirshov.simpleqrscanner.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorPage(errorText:String){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Permission not")
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorPagePreview(){
    ErrorPage(errorText = "Not Camera Permission")
}