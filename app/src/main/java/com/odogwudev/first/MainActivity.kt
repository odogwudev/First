package com.odogwudev.first

import androidx.appcompat.app.AppCompatActivity;
import android.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper
import android.view.View;
import android.view.WindowInsets
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )


            val title: TextView = findViewById(R.id.tvTitle)
            val slogan: TextView = findViewById(R.id.tvSlogan)
            val image: ImageView = findViewById(R.id.ivCar)

            val topAnim = AnimationUtils.loadAnimation(this@MainActivity, R.anim.top_animation)
            val bottomAnim =
                AnimationUtils.loadAnimation(this@MainActivity, R.anim.bottom_animation)


            val pair = listOf<Pair<View, String>>(
                Pair<View, String>(image, "logo_image"),
                Pair<View, String>(title, "logo_text"),
            )
            val options: ActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(this, pair[0], pair[1])
            Intent(this, MainActivity::class.java).also {
                startActivity(it, options.toBundle())
            }


            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }, 5000)
        }


    }
}