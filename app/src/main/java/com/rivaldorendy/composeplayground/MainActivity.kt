package com.rivaldorendy.composeplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.OutlinedButton
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rivaldorendy.composeplayground.theme.AppThemeState
import com.rivaldorendy.composeplayground.theme.BaseView
import com.rivaldorendy.composeplayground.theme.SystemUiController
import com.rivaldorendy.composeplayground.model.Menu
import com.rivaldorendy.composeplayground.ui.basic.AnimatePlayground
import com.rivaldorendy.composeplayground.ui.basic.ButtonPlayground
import com.rivaldorendy.composeplayground.ui.basic.ListPlayground
import com.rivaldorendy.composeplayground.ui.basic.ModifierPlayground
import com.rivaldorendy.composeplayground.ui.basic.RowColumnPlayground
import com.rivaldorendy.composeplayground.ui.basic.StatePlayground
import com.rivaldorendy.composeplayground.ui.basic.TextPlayground

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }
            BaseView(appTheme.value, systemUiController) {
                MainScreen()
            }
        }
    }

    @Preview
    @Composable
    fun MainScreen() {
        Column(Modifier.background(MaterialTheme.colors.background)) {
            TopAppBar(
                title = { Text(text = "Compose Playground", color = Color.White) },
            )
            LazyColumn {
                items(getComponents()) {
                    ButtonComponent(it.name, it.activity)
                }
            }
        }
    }

    @Composable
    fun ButtonComponent(buttonText: String, className: Class<*>) {
        val context = LocalContext.current
        OutlinedButton(
            onClick = {
                context.startActivity(Intent(applicationContext, className))
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary.copy(0.04f)),
            border = BorderStroke(2.dp, MaterialTheme.colors.primary.copy(0.5f)),
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = buttonText,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary
            )
        }
    }

    private fun getComponents() = listOf(
        Menu(getString(R.string.text_playground), TextPlayground::class.java),
        Menu(getString(R.string.row_and_column_playground), RowColumnPlayground::class.java),
        Menu(getString(R.string.button_playground), ButtonPlayground::class.java),
        Menu(getString(R.string.modifier_playground), ModifierPlayground::class.java),
        Menu(getString(R.string.state_playground), StatePlayground::class.java),
        Menu(getString(R.string.list_playground), ListPlayground::class.java),
        Menu(getString(R.string.animate_playground), AnimatePlayground::class.java)
    )
}