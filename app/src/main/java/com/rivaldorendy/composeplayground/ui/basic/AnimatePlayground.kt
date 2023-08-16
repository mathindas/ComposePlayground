package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rivaldorendy.composeplayground.theme.green200
import com.rivaldorendy.composeplayground.theme.red200

class AnimatePlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimateCompose()
        }
    }
}

@Composable
fun AnimateCompose() {
    var size by remember {
        mutableStateOf(100.dp)
    }
    val sizeAnim by animateDpAsState(
        targetValue = size,
        tween(
            durationMillis = 1000
        ), label = "size animation"
    )

    val colorAnim = rememberInfiniteTransition(label = "infinite color")
    val color by colorAnim.animateColor(
        initialValue = red200,
        targetValue = green200,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 1000
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "color animation"
    )


    Box(
        modifier = Modifier
            .size(sizeAnim)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                size += 50.dp
            }
        ) {
            Text("Increase Size")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AnimatePreview() {
    AnimateCompose()
}


