package com.rivaldorendy.composeplayground.ui.basic

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rivaldorendy.composeplayground.theme.blue700

class ButtonPlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonCompose(this@ButtonPlayground)
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ButtonPreview() {
        ButtonCompose(this@ButtonPlayground)
    }
}


@Composable
fun ButtonCompose(context : Context) {
    Column {
        val interactionSource = remember { MutableInteractionSource() }
        Button(
            onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.padding(16.dp),
            enabled = true,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(blue700),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            border = BorderStroke(2.dp, Color.Black),
            contentPadding = PaddingValues(12.dp),
            interactionSource = interactionSource,
        ) {
            Text("Tekan Saya!")
        }

    }
}





