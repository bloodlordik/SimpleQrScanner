package ru.kirshov.simpleqrscanner.tools

import android.content.ClipboardManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberClipboardManager(): ClipboardManager {
    val context = LocalContext.current
    val clipboardManager:ClipboardManager by remember {
        mutableStateOf(
            context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        )
    }

    return clipboardManager
}