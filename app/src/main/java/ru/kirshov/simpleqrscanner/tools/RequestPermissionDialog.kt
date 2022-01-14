package ru.kirshov.simpleqrscanner.tools

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun RequestPermissionDialog(
    content: @Composable ()->Unit,
    error: @Composable ()->Unit
){
    val context = LocalContext.current
    var hasPermission:Boolean by remember {
        mutableStateOf(
            context.checkCameraPermission()
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {granted-> hasPermission = granted})
    LaunchedEffect(key1 = true, block = {
        launcher.launch(Manifest.permission.CAMERA)
    })
    if (hasPermission){
        content()
    }else{
        error()
    }
}