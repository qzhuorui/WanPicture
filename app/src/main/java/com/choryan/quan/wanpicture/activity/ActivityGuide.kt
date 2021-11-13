package com.choryan.quan.wanpicture.activity

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.choryan.quan.wanpicture.R
import com.choryan.quan.wanpicture.base.BaseActivity
import com.choryan.quan.wanpicture.constants.PathConstant
import com.choryan.quan.wanpicture.spf.SPFBaseConfig
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.LoopingMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import kotlinx.android.synthetic.main.activity_guide.*

class ActivityGuide : BaseActivity(R.layout.activity_guide) {

    private val player by lazy {
        val myPlayer = SimpleExoPlayer.Builder(this).build()
        myPlayer.playWhenReady = true
        myPlayer
    }
    private val mediaSourceFactory by lazy {
        val myMediaSourceFactory = DefaultMediaSourceFactory(this)
        myMediaSourceFactory
    }

    private var pageCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SPFBaseConfig.guideFirstShow = false

        pv_guide.setShutterBackgroundColor(Color.TRANSPARENT)
        //ZOOM:增加宽度或高度以获得所需的纵横比
        pv_guide.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

        firstInitVideo("iphone_A.mp4", "iphone_A1.mp4")

        initClick()
    }

    private fun initClick() {
        tv_guide_next.setOnClickListener {
            guideNext()
        }
    }

    private fun firstInitVideo(noLoopVideo: String, loopVideo: String) {
        val noLoopSource = MediaItem.fromUri(PathConstant.PATH_ASSETS + noLoopVideo)

        val loopMediaSource =
            mediaSourceFactory.createMediaSource(MediaItem.fromUri(PathConstant.PATH_ASSETS + loopVideo))
        val loopingMediaSource = LoopingMediaSource(loopMediaSource, Int.MAX_VALUE)

        player.addMediaItem(noLoopSource)
        player.addMediaSource(loopingMediaSource)

        val videoSurfaceView = pv_guide.videoSurfaceView
        if (videoSurfaceView is SurfaceView) {
            videoSurfaceView.holder.addCallback(object : SurfaceHolder.Callback {
                override fun surfaceCreated(holder: SurfaceHolder) {
                    pv_guide.player = player
                    player.prepare()
                }

                override fun surfaceChanged(
                    holder: SurfaceHolder,
                    format: Int,
                    width: Int,
                    height: Int
                ) {
                }

                override fun surfaceDestroyed(holder: SurfaceHolder) {
                }
            })
        }
    }

    private fun changeVideoSource(noLoopVideo: String, loopVideo: String) {
        val noLoopSource = MediaItem.fromUri(PathConstant.PATH_ASSETS + noLoopVideo)

        val loopMediaSource =
            mediaSourceFactory.createMediaSource(MediaItem.fromUri(PathConstant.PATH_ASSETS + loopVideo))
        val loopingMediaSource = LoopingMediaSource(loopMediaSource, Int.MAX_VALUE)

        player.stop(true)
        player.addMediaItem(noLoopSource)
        player.addMediaSource(loopingMediaSource)
        player.prepare()
    }

    override fun onResume() {
        super.onResume()
        if (!player.isPlaying) {
            player.play()
        }
    }

    override fun onPause() {
        super.onPause()
        if (player.isPlaying) {
            player.pause()
        }
    }

    override fun onDestroy() {
        player.release()
        super.onDestroy()
    }

    private fun guideNext() {
        pageCount++
        when (pageCount) {
            1 -> {
                pv_guide.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH
                vibrate()
                changeVideoSource("9-19_B.mp4", "9-19_B1.mp4")
            }
            2 -> {
                pv_guide.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                vibrate()
                changeVideoSource("iphone_C.mp4", "iphone_C1.mp4")
            }
            else -> {
                ActivityHome.start(this)
            }
        }
    }

    private fun vibrate(millisecond: Long = 300) {
        val vibrateService = getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            vibrateService.vibrate(VibrationEffect.createOneShot(millisecond, 10))
        } else {
            vibrateService.vibrate(millisecond)
        }
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, ActivityGuide::class.java)
            context.startActivity(intent)
            if (context is Activity) {
                context.finish()
                context.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out)
            }
        }
    }
}