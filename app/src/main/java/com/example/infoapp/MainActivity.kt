package com.example.infoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.infoapp.ui.theme.InfoAppTheme
import com.example.infoapp.ui_components.DrawerMenu
import com.example.infoapp.ui_components.MainTopBar
import com.example.infoapp.utils.DrawerEvents
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            val topBarTitle = remember {
                mutableStateOf("Грибы")
            }
            InfoAppTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MainTopBar(
                            title = topBarTitle.value,
                            scaffoldState
                        )
                    },
                    drawerContent = {
                        DrawerMenu(){ event ->
                            when(event){
                                is DrawerEvents.OnItemClick -> {
                                    topBarTitle.value = event.title
                                }
                            }
                            coroutineScope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    }
                ) {

                }
            }
        }
    }
}