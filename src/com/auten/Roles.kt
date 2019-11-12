package com.auten.softwareengineering

enum class Roles {
    WRITE, READ, EXECUTE;

    companion object {
        fun isRoleExist(role: String) = values().any { it.toString() == role }
    }
}


