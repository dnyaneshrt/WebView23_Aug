package com.tech.webviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    var anim_view: LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        anim_view = findViewById(R.id.animation_view)

//        anim_view?.setAnimation(R.raw.education)
        anim_view?.animate()


        Handler().postDelayed({
            //this code will execute after 3 seconds
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, 5500)
    }
}

