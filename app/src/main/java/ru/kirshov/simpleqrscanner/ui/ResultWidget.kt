package ru.kirshov.simpleqrscanner.ui

import android.content.ClipData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kirshov.simpleqrscanner.R
import ru.kirshov.simpleqrscanner.tools.rememberClipboardManager
import ru.kirshov.simpleqrscanner.tools.rememberToast

private const val label = "text"

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ResultWidget(result:String){

    val toast = rememberToast(text = stringResource(id = R.string.toast_message))
    val clipboardManager = rememberClipboardManager()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            onClick = {
                val clipData = ClipData.newPlainText(label,result)
                clipboardManager.setPrimaryClip(clipData)
                toast.show()
            },
            backgroundColor = MaterialTheme.colors.background,
            elevation = 4.dp,
            shape = MaterialTheme.shapes.small
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Text(
                    text = result,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 24.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_copy),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.BottomEnd).offset(x = (-8).dp, y = (-8).dp)
                )
            }
        }

}

private const val previewText = "https://music.yandex.ru/home?utm_source=main_stripe_big"
@Preview(showBackground = true)
@Composable
fun ResultWidgetPreview(){
    ResultWidget(result = previewText)
}

