package com.auten.softwareengineering

enum class Roles {
    WRITE, READ, EXECUTE
}

fun isRoleExist(role: String) = Roles.values().any { it.toString() == role }
