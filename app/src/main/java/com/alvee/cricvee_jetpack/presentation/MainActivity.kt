package com.alvee.cricvee_jetpack.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alvee.cricvee_jetpack.presentation.components.screen.RootScreen
import com.alvee.cricvee_jetpack.presentation.ui.theme.CricVeejetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val fixtureViewModel: FixtureViewModel = hiltViewModel()
            CricVeejetpackTheme {
                // A surface container using the 'background' color from the theme
                RootScreen()
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CricVeejetpackTheme {
        Greeting("Android")
    }
}