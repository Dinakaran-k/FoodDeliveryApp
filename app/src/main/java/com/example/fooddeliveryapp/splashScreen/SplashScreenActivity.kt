package com.example.fooddeliveryapp.splashScreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.fooddeliveryapp.MainActivity
import com.example.fooddeliveryapp.ui.theme.AppTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            val splashScreen = installSplashScreen()
            super.onCreate(savedInstanceState)

            var keepOnScreen = true
            splashScreen.setKeepOnScreenCondition { keepOnScreen }

            setContent {
                AppTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        LaunchedEffect(Unit) {
                            delay(2000) // 2 seconds delay
                            keepOnScreen = false
                            startActivity(MainActivity.newIntent(this@SplashScreenActivity))
                            finish()
                        }
                    }
                }
            }
        }


}