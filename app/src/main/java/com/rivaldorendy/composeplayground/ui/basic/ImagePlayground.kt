package com.rivaldorendy.composeplayground.ui.basic

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rivaldorendy.composeplayground.R
import com.rivaldorendy.composeplayground.theme.blue500
import com.rivaldorendy.composeplayground.theme.green200
import com.rivaldorendy.composeplayground.theme.red200

class ImagePlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageCompose()
        }
    }
}

@Composable
fun ImageCompose() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null
    )
    Icon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = null,
        tint = blue500
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImagePreview() {
    ImageCompose()
}


