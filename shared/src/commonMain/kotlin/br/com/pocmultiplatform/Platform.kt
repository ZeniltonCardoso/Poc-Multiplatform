package br.com.pocmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform