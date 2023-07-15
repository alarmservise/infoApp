@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.infoapp.ui_components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
fun <ScaffoldState> MainTopBar(title: String, scaffoldState: ScaffoldState) {
    val coroutine = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(text = title)
        },
        //        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = {
                    coroutine.launch {
                        //scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            }
        }
    )
}