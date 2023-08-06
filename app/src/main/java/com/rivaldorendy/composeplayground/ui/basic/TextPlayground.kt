package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.rivaldorendy.composeplayground.theme.ComposePlaygroundTheme

class TextPlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello, my name is $name\nNice to meet You\nWhat's your name?",
        modifier = modifier,
        color = Color.Blue,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 0.1.em,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        lineHeight = 50.sp,
        overflow = TextOverflow.Ellipsis,
        softWrap = true,
        maxLines = 2,
        onTextLayout = { textLayoutResult ->
            val firstLineBaseline = textLayoutResult.getLineTop(0)
            val lastLineBaseline = textLayoutResult.getLineBottom(0)
            val textHeight = lastLineBaseline - firstLineBaseline
            println("Text Height: $textHeight")
        },
        style = LocalTextStyle.current
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePlaygroundTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorScheme.background
        ) {
            Greeting("Android")
        }
    }
}

