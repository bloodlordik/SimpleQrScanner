package ru.kirshov.simpleqrscanner.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationBar(){
    BottomAppBar(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Scan Qr code")
        Text(text = "Generate Qr code")
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview(){
    BottomNavigationBar()
}