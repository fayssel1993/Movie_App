package com.yabasoft.movies.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

/**
 * Created by Fayssel Yabahddou on 20/4/2023.
 */

@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    args: String? = null
) {

    args?.let { Text(text = it) }
}