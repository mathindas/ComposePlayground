package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ListPlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListCompose()
        }
    }
}

@Composable
fun ListCompose() {
    val listItem = mutableListOf<String>()
    for (i in 1..50) {
        listItem.add("List $i")
    }
    LazyColumn {
        itemsIndexed(listItem) {
            index, string ->
                Text(
                    text = string,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListPreview() {
    ListCompose()
}


