package com.tezov.rouedelice.client

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform