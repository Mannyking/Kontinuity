package com.toyelabs.financelabs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo

@Composable
// TODO rewrite to use/leverage Responsive.kt
fun Gap(
    h: Float = 0f,
    w: Float = 0f
) {
    val density = LocalDensity.current
    val containerSize = LocalWindowInfo.current.containerSize

    val heightDp = with(density) { containerSize.height.toDp() }
    val widthDp = with(density) { containerSize.width.toDp() }

    Spacer(
        modifier = Modifier
            .height(heightDp * h / 100)
            .width(widthDp * w / 100)
    )
}

fun test() {

}
