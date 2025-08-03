package com.toyelabs.financelabs.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp

val Float.h: Dp
    @Composable
    get() {
        val density = LocalDensity.current
        val containerHeight = LocalWindowInfo.current.containerSize.height

        return with(density) { containerHeight.toDp() * this@h / 100 }
    }

val Float.w: Dp
    @Composable
    get() {
        val density = LocalDensity.current
        val containerWidth = LocalWindowInfo.current.containerSize.width

        return with(density) { containerWidth.toDp() * this@w / 100 }
    }

val Int.h: Dp
    @Composable
    get() {
        val density = LocalDensity.current
        val containerHeight = LocalWindowInfo.current.containerSize.height

        return with(density) { containerHeight.toDp() * this@h / 100 }
    }

val Int.w: Dp
    @Composable
    get() {
        val density = LocalDensity.current
        val containerWidth = LocalWindowInfo.current.containerSize.width

        return with(density) { containerWidth.toDp() * this@w / 100 }
    }

val Double.h: Dp
    @Composable
    get() {
        val density = LocalDensity.current
        val containerHeight = LocalWindowInfo.current.containerSize.height

        return with(density) { containerHeight.toDp() * this@h.toFloat() / 100 }
    }

val Double.w: Dp
    @Composable
    get() {
        val density = LocalDensity.current
        val containerWidth = LocalWindowInfo.current.containerSize.width

        return with(density) { containerWidth.toDp() * this@w.toFloat() / 100 }
    }
