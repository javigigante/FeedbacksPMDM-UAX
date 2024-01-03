package com.javigigante.feedbackud3

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.javigigante.feedbackud3.databinding.ActivityMainBinding
import android.R

private lateinit var binding : ActivityMainBinding
private lateinit var videoView : VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoView = binding.videoView

        val videoResourceID = ""

        val videoPath = "android.resources://" + packageName + "/R.raw.video1"
        val videoPath2 = "/mnt/sdcard/video.mp4"

        val videoURI = Uri.parse(videoPath)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoURI)

        /*
        videoView.setOnPreparedListener {
                mediaPlayer -> mediaPlayer.setOnVideoSizeChangedListener { _, _, _ ->

                    /*
                        -- POR SI QUEREMOS HACER UN RESIZE DE LAS PROPORCIONES DEL REPRODUCTOR
                        --          SEGÚN LAS PROPORCIONES DEL PROPIO VÍDEO
                    */

                    val width = mediaPlayer.videoWidth
                    val height = mediaPlayer.videoHeight
                    val proportions = width.toFloat() / height.toFloat()

                    val screenWidth = resources.displayMetrics.widthPixels
                    val screenHeight = resources.displayMetrics.heightPixels
                    val screenProportions = screenWidth.toFloat() / screenHeight.toFloat()

                    val scale = proportions / screenProportions

                    val layoutParams = videoView.layoutParams
                    layoutParams.width = screenWidth
                    layoutParams.height = (screenHeight * scale).toInt()

                    videoView.layoutParams = layoutParams
                }

        }


         */
        videoView.requestFocus()
        videoView.start()

    }
}