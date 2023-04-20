package com.yabasoft.movies.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yabasoft.movies.R
import com.yabasoft.movies.navigation.MovieScreens

/**
 * Created by Fayssel Yabahddou on 20/4/2023.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = LocalContext.current.getString(R.string.app_name))
                },
                modifier = modifier,
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        }
    ) {
        MainContent(modifier.padding(it), navController)
    }
}

@Composable
fun MainContent(
    modifier: Modifier,
    navController: NavHostController
) {
    val items = listOf("Avatar", "God father", "Scent of a women", "Scare face", "Fight club")
    Column(modifier = modifier) {
        LazyColumn {
            items(items) {
                MovieRow(it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen().route+"/$movie")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MovieRow(
    movie: String = "Niiiiiiice",
    onItemClick: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable { onItemClick.invoke(movie) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

        ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RectangleShape,
                tonalElevation = 4.dp
            ) {
                Icon(
                    modifier = Modifier.size(100.dp),
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = movie
            )
        }
    }
}
