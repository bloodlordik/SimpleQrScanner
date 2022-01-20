package ru.kirshov.simpleqrscanner.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kirshov.simpleqrscanner.tools.rememberToast



@Composable
fun ResultWidget(result:String){
    val toast = rememberToast(text = "click")
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .clickable{ toast.show()}, contentAlignment = Alignment.Center){
        Text(text = result)
    }
}

