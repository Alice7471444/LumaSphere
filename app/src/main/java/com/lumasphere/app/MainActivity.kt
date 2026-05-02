package com.lumasphere.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.lumasphere.app.ui.navigation.LumaSphereNavHost
import com.lumasphere.app.ui.theme.LumaSphereTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumaSphereTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LumaSphereNavHost()
                }
            }
        }
    }
}