package com.toyelabs.financelabs.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/*-------------------------------------------------------------------*/

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val BurntOrange500 = Color(0xFFB34700) // slightly darker
val BurntOrange700 = Color(0xFFCC5500) // deep burnt orange

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val NavyBlue100 = Color(0xFF4C5CD0)
val NavyBlue300 = Color(0xFF004C90)
val NavyBlue500 = Color(0xFF002D5F)
val NavyBlue700 = Color(0xFF142540)

val PowderBlue500 = Color(0xFF476EA4)

val TurquoiseBlue100 = Color(0xFFB3E5FC)
val TurquoiseBlue300 = Color(0xFF4FC3F7)
val TurquoiseBlue500 = Color(0xFF03A9F4)
val TurquoiseBlue700 = Color(0xFF0288D1)

val Transparent = Color(0x00FFFFFF)

val SemiTransparent = Color(0x10FFFFFF)

val LightGreen100 = Color(0xFFB2EAC1)
val LightGreen400 = Color(0xFF66D483)
val Green300 = Color(0xFF4CAF50)
val Green500 = Color(0xFF00FF00)
val Aqua300 = Color(0xFF80DB98)
val Aqua500 = Color(0xFF00FFBF)
val Lemon300 = Color(0xFFADD136)
val Lemon500 = Color(0xFF8BC34A)
val DarkGreen500 = Color(0xFF2B4928)
val DarkGreen700 = Color(0xFF00401A)
val Teal500 = Color(0xFF018786)

val DarkGray500 = Color(0xFF323232)
val DarkGray300 = Color(0xFF555555)
val DarkGray700 = Color(0xFF1A1A1A)
val Gray100 = Color(0xFFE3E3E3)
val Gray500 = Color(0xFF959595)
val Gray600 = Color(0xFF848485)

val Purple500 = Color(0xFF800080)
val Orange500 = Color(0xFFFF5800)
val Peach700 = Color(0xFFF6313F)
val Red500 = Color(0xFFFF0000)
val Pink500 = Color(0xFFFFC0CB)
val Orange300 = Color(0xFFFF8F00)
val Yellow500 = Color(0xFFFFFF00)
val HoloRedDark = Color(0xFFCC0000)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

/* ---------------------------colors that pertain to views and similar--------------------------- */
val TextDark = Black
val TextLight = Gray100

val BackgroundLight = Gray500
val BackgroundDark = DarkGray700

val ColorPrimary = BurntOrange700
val ColorPrimaryDark = BurntOrange500

val ColorSecondary = NavyBlue500
val ColorSecondaryDark = TurquoiseBlue500

val ColorTertiary = LightGreen400
val ColorTertiaryDark = LightGreen100

/*-------------------------------------------------------------------------------------------*/

val LightColors = lightColorScheme(
    primary = ColorPrimary,
    onPrimary = Color.White,
    secondary = Color.DarkGray,
    background = BackgroundLight,
    onBackground = TextDark,
    surface = Color.White,
    onSurface = Color.Black
)

val DarkColors = darkColorScheme(
    primary = ColorPrimaryDark,
    onPrimary = Color.Black,
    secondary = Color.Gray,
    background = BackgroundDark,
    onBackground = TextLight,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White
)
