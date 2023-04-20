package com.yabasoft.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yabasoft.movies.navigation.MovieNavigation
import com.yabasoft.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MovieApp(content: @Composable () -> Unit) {
    MoviesTheme {
        content()
    }
}

@Preview
@Composable
fun Preview(){
    MovieApp {
        MovieNavigation()
    }
}