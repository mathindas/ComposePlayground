package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rivaldorendy.composeplayground.theme.blue200
import com.rivaldorendy.composeplayground.theme.green200
import com.rivaldorendy.composeplayground.theme.orange200
import com.rivaldorendy.composeplayground.theme.red200

class RowColumnPlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowColumnCompose()
        }
    }
}


@Composable
fun RowColumnCompose() {
    Column{
        Row(
            modifier = Modifier
                .background(blue200)
                .fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .background(green200)
                    .fillMaxSize(0.5f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Row 1")
                Text("Row 2")
                Text("Row 3")
                Text("Row 3")
            }

            Column(
                modifier = Modifier
                    .background(red200)
                    .fillMaxSize(0.5f)
                    .padding(10.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceAround
            ){
                Text("Column 1")
                Text("Column 2")
                Text("Column 3")
                Text("Column 3")
            }
        }
        Column(
            modifier = Modifier
                .background(orange200)
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .background(red200)
                    .fillMaxSize(0.5f)
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text("Column 1")
                Text("Column 2")
                Text("Column 3")
                Text("Column 3")
            }
            Row(
                modifier = Modifier
                    .background(green200)
                    .fillMaxSize(0.5f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Row 1")
                Text("Row 2")
                Text("Row 3")
                Text("Row 3")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowColumnPreview() {
    RowColumnCompose()
}


