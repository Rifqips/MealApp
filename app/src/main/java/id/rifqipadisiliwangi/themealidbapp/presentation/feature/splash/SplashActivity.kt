package id.rifqipadisiliwangi.themealidbapp.presentation.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import coil.load
import id.rifqipadisiliwangi.themealidbapp.R
import id.rifqipadisiliwangi.themealidbapp.databinding.ActivitySplashBinding
import id.rifqipadisiliwangi.themealidbapp.presentation.feature.dashboard.DashboardActivity

class SplashActivity : AppCompatActivity() {

    private val binding : ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivImgSplash.load("https://www.themealdb.com/images/ingredients/Lime.png")
        Handler().postDelayed({
            navigateToDashBoard()
        }, 3000)
    }

    private fun navigateToDashBoard() {
        val intent = Intent(this, DashboardActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }
}