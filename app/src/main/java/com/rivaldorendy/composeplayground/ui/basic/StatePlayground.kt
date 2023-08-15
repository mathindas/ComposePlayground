package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class StatePlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateCompose()
        }
    }
}

@Composable
fun StateCompose() {
    val color = remember{
        mutableStateOf(Color.Blue)
    }
    Box(
        modifier = Modifier
            .background(color.value)
            .clickable { 
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                )
            }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StatePreview() {
    StateCompose()
}


