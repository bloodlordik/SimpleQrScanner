package ru.kirshov.simpleqrscanner.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import ru.kirshov.simpleqrscanner.R
import ru.kirshov.simpleqrscanner.tools.RequestPermissionDialog


@Composable
fun Screen(){
    RequestPermissionDialog(content = { Content()  },
    error = { ErrorPage(errorText = stringResource(id = R.string.camera_error)) })
    
}
