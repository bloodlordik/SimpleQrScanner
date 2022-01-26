package ru.kirshov.simpleqrscanner.ui

import android.content.ClipData
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kirshov.simpleqrscanner.R
import ru.kirshov.simpleqrscanner.tools.rememberClipboardManager
import ru.kirshov.simpleqrscanner.tools.rememberToast



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ResultWidget(result:String){
    val context = LocalContext.current
    val toast = rememberToast(text = context.getString(R.string.toast_message))
    val clipboardManager = rememberClipboardManager()
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)){
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val clipData = ClipData.newPlainText("text",result)
                clipboardManager.setPrimaryClip(clipData)
                toast.show()
            },
            backgroundColor = MaterialTheme.colors.background,
            elevation = 4.dp
        ) {
            Text(modifier = Modifier.padding(4.dp), text = result)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultWidgetPreview(){
    ResultWidget(result = "ggggggggdgdggdd")
}

