package ru.kirshov.simpleqrscanner.tools

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

val Context.executor: Executor get() = ContextCompat.getMainExecutor(this)

suspend fun Context.cameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
    ProcessCameraProvider.getInstance(this).also { future->
        future.addListener({
                           continuation.resume(future.get())
        }, executor)
    }

}

fun Context.checkCameraPermission():Boolean{
    return ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
}