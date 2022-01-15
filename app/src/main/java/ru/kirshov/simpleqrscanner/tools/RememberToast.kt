package ru.kirshov.simpleqrscanner.tools

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberToast(text:String):Toast{
    val context = LocalContext.current
    val toast:Toast by remember {
        mutableStateOf(
            Toast.makeText(context, text, Toast.LENGTH_SHORT)
        )
    }
    return toast
}