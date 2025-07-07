package com.toyelabs.financelabs.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import financelabs.composeapp.generated.resources.Res
import financelabs.composeapp.generated.resources.doto_black
import financelabs.composeapp.generated.resources.doto_bold
import financelabs.composeapp.generated.resources.doto_extrabold
import financelabs.composeapp.generated.resources.doto_extralight
import financelabs.composeapp.generated.resources.doto_light
import financelabs.composeapp.generated.resources.doto_medium
import financelabs.composeapp.generated.resources.doto_regular
import financelabs.composeapp.generated.resources.doto_semibold
import financelabs.composeapp.generated.resources.doto_thin
import org.jetbrains.compose.resources.Font

@Composable
fun dotoFontFamily() = FontFamily(
        Font(Res.font.doto_black, FontWeight.Black),
        Font(Res.font.doto_bold, FontWeight.Bold),
        Font(Res.font.doto_extrabold, FontWeight.ExtraBold),
        Font(Res.font.doto_extralight, FontWeight.ExtraLight),
        Font(Res.font.doto_light, FontWeight.Light),
        Font(Res.font.doto_medium, FontWeight.Medium),
        Font(Res.font.doto_regular, FontWeight.Normal),
        Font(Res.font.doto_semibold, FontWeight.SemiBold),
        Font(Res.font.doto_thin, FontWeight.Thin)
)
