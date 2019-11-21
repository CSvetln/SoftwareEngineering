package com.auten.service.softwareengineering

import java.security.MessageDigest

class Hasher { //класс для хеширрования
    companion object {
        fun getHash(pass: String): String {
            val bytes = pass.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }
    }
}