package com.yabasoft.movies.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

/**
 * Created by Fayssel Yabahddou on 20/4/2023.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    movie: String? = null
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = movie.toString())
                },
                navigationIcon = {
                    Icon(
                        modifier = modifier
                            .clickable {
                                navHostController.popBackStack()
                            },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "go back"
                    )
                },
                modifier = modifier,
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
        ) {
            Text(text = movie.toString())
        }
    }
}