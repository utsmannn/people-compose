package com.utsman.peoples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.utsman.peoples.navigation.LocalNavigationProvider
import com.utsman.peoples.navigation.NavigationProvider
import com.utsman.peoples.navigation.NavigationProviderImpl
import com.utsman.peoples.ui.theme.PeoplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navHotController = rememberNavController()
    val navigationProvider: NavigationProvider = remember {
        NavigationProviderImpl(navHotController)
    }

    CompositionLocalProvider(
        LocalNavigationProvider provides navigationProvider
    ) {
        PeoplesTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                MainGraph(navHostController = navHotController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainApp()
}