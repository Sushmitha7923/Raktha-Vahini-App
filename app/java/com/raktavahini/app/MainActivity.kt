package com.raktavahini.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import com.raktavahini.app.navigation.AppNavigation
import com.raktavahini.app.ui.theme.RaktaVahiniTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔥 Initialize Firebase
        FirebaseApp.initializeApp(this)

        setContent {

            // 🎨 Apply App Theme
            RaktaVahiniTheme {

                // 🔗 Start Navigation Graph
                AppNavigation()
            }
        }
    }
}