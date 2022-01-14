package ru.kirshov.simpleqrscanner.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kirshov.simpleqrscanner.imageAnalizer.QrCodeAnalysis

@Composable
fun Content(){
    var qrCodeResult by remember {
        mutableStateOf("Qr code")
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        CameraView(
            modifier = Modifier.padding(12.dp).aspectRatio(1F),
            imageAnalysis = QrCodeAnalysis{
                qrCodeResult = it
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = qrCodeResult)
    }
}