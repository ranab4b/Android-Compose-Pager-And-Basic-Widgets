package com.example.basicwidgetsalongwithpager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun MyTextViewWithCustomFont() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Jetpack Compose",
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = getFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline

        )
    }
}

fun getFontFamily() : FontFamily{
    return FontFamily(
        Font(R.font.lexend_black, FontWeight.Black),
        Font(R.font.lexend_bold, FontWeight.Bold),
        Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
        Font(R.font.lexend_extralight, FontWeight.ExtraLight),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_regular, FontWeight.Normal),
        Font(R.font.lexend_semibold, FontWeight.SemiBold),
        Font(R.font.lexend_thin, FontWeight.Thin)
    )
}

@Composable
fun AnnotatedTextViewWithCustomFont() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 50.sp,
                        textDecoration = TextDecoration.None
                    )
                )
                {
                    append("J")
                }
                append("etpac ")

                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 50.sp,
                        textDecoration = TextDecoration.None
                    )
                )
                {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = getFontFamily(),
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline

        )
    }
}