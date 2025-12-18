package com.hussein.navigation3cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform