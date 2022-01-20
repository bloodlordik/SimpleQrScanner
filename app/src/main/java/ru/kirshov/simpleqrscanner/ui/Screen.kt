package ru.kirshov.simpleqrscanner.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import ru.kirshov.simpleqrscanner.R
import ru.kirshov.simpleqrscanner.tools.RequestPermissionDialog


@Composable
fun Screen(modifier: Modifier = Modifier){
    val context = LocalContext.current
    RequestPermissionDialog(content = { Content()  },
    error = { ErrorPage(errorText = context.getString(R.string.camera_error)) })
    
}
