package com.auten.domain.softwareengineering

data class User(val login: String, val hash: String, val salt: String)