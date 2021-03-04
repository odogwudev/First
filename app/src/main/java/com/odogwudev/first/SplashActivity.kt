package com.odogwudev.first

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val textView: TextView = findViewById(R.id.txt_v)
        val imageView: ImageView = findViewById(R.id.image_view)

        val animationUpToDown =
            AnimationUtils.loadAnimation(this@SplashActivity, R.anim.uptodownanim)
        val animationDownToUp =
            AnimationUtils.loadAnimation(this@SplashActivity, R.anim.downtotopanim)

        imageView.animation = animationUpToDown
        textView.animation = animationDownToUp

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 4000)
    }
}