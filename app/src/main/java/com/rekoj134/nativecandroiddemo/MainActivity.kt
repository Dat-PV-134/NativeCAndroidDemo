package com.rekoj134.nativecandroiddemo

import android.app.ActivityManager
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var glSurfaceView: GLSurfaceView? = null
    private var rendererSet = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val configurationInfo = activityManager.deviceConfigurationInfo

        val supportsEs2 =
            configurationInfo.reqGlEsVersion >= 0x20000

        if (supportsEs2) {
            glSurfaceView = GLSurfaceView(this)

            glSurfaceView?.setEGLConfigChooser(8, 8, 8, 8, 16, 0)

            glSurfaceView?.setEGLContextClientVersion(2)
            glSurfaceView?.setRenderer(RendererWrapper())
            rendererSet = true
            setContentView(glSurfaceView)
        } else {
            Toast.makeText(
                this, "This device does not support OpenGL ES 2.0.",
                Toast.LENGTH_LONG
            ).show()
            return
        }
    }

    override fun onPause() {
        super.onPause()

        if (rendererSet) {
            glSurfaceView?.onPause()
        }
    }

    override fun onResume() {
        super.onResume()

        if (rendererSet) {
            glSurfaceView?.onResume()
        }
    }
}