package ru.kirshov.simpleqrscanner.ui


import android.util.Log
import android.util.Size
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis

import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.launch
import ru.kirshov.simpleqrscanner.imageAnalizer.QrCodeAnalysis
import ru.kirshov.simpleqrscanner.tools.cameraProvider


@Composable
fun CameraView(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
    scaleType: PreviewView.ScaleType = PreviewView.ScaleType.FILL_CENTER,
    imageAnalysis: ImageAnalysis.Analyzer? = null
){
    val coroutineScope = rememberCoroutineScope()
    val lifecycleOwner = LocalLifecycleOwner.current
    AndroidView(modifier = modifier, factory = { context ->
        val previewView = PreviewView(context).apply {
            this.scaleType = scaleType
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        val previewUseCase = Preview.Builder()
            .build()
            .also { it.setSurfaceProvider(previewView.surfaceProvider) }
        val imageAnalyzer = ImageAnalysis.Builder()
            .setTargetResolution(Size(previewView.width, previewView.height))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
        imageAnalysis?.let { analyzer ->
            imageAnalyzer.setAnalyzer(
                ContextCompat.getMainExecutor(context),
                analyzer
            )
        }

        coroutineScope.launch {
            val cameraProvider = context.cameraProvider()
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner, cameraSelector, previewUseCase, imageAnalyzer
                )
            }catch (ex: Exception){
                Log.e("Camera", "Camerra Initial")
            }
        }

        previewView
    })
}