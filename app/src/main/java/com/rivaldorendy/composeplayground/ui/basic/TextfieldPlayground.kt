package com.rivaldorendy.composeplayground.ui.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rivaldorendy.composeplayground.R


class TextfieldPlayground : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextfieldCompose()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextfieldCompose() {
    var text by remember { mutableStateOf(TextFieldValue()) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        enabled = true,
        readOnly = false,
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp),
        label = {Text("Label")},
        placeholder = { Text(text = "Placeholder") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "User Icon"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "User Icon"
            )
        },
        isError = false,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        interactionSource = interactionSource,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextfieldComposePreview() {
    TextfieldCompose()
}


