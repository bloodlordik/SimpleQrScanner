package ru.kirshov.simpleqrscanner.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ru.kirshov.simpleqrscanner.R
import ru.kirshov.simpleqrscanner.tools.RequestPermissionDialog


@Composable
fun Screen(modifier: Modifier = Modifier){
    val context = LocalContext.current
    RequestPermissionDialog(content = { Content()  },
    error = { ErrorPage(errorText = context.getString(R.string.camera_error)) })
    
}
