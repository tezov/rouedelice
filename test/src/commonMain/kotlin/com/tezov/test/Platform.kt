package com.tezov.test

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform