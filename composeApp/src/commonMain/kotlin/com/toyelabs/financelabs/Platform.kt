package com.toyelabs.financelabs

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform