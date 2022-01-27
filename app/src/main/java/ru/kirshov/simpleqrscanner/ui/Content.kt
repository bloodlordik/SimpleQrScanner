package ru.kirshov.simpleqrscanner.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kirshov.simpleqrscanner.imageAnalizer.QrCodeAnalysis

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Content(){
    var qrCodeResult by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Card(elevation = 4.dp) {
            CameraView(
                modifier = Modifier.aspectRatio(1F),
                imageAnalysis = QrCodeAnalysis{
                    qrCodeResult = it
                }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        AnimatedVisibility(visible = qrCodeResult.isNotBlank()) {
            CameraView(
                modifier = Modifier.aspectRatio(1F),
                imageAnalysis = QrCodeAnalysis{
                    qrCodeResult = it
                }
            )
        }
    }
}