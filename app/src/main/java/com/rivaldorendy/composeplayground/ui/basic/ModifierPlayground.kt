package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rivaldorendy.composeplayground.theme.blue700
import com.rivaldorendy.composeplayground.theme.pink200
import com.rivaldorendy.composeplayground.theme.purple200
import com.rivaldorendy.composeplayground.theme.red700

class ModifierPlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierCompose()
        }
    }
}

@Composable
fun ModifierCompose() {
    Column(
        modifier = Modifier
            .background(pink200)
            .height(200.dp)
            .width(200.dp)
            .border(5.dp, red700)
            .padding(50.dp)
            .border(10.dp, blue700)
            .border(20.dp, purple200)
    ) {
        Text("Hello World")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ModifierPreview() {
    ModifierCompose()
}


