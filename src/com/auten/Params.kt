package com.auten.softwareengineering

import kotlinx.cli.*

class Params(args: Array<String>) {
    private val parser = ArgParser("example")
    val login by parser.option(ArgType.String, shortName = "login")
    val hash by parser.option(ArgType.String, shortName = "pass")
    val isHelp by parser.option(ArgType.Boolean, shortName = "-h")
    val res by parser.option(ArgType.String, shortName = "res")
    val role by parser.option(ArgType.String, shortName = "role")

    init {
        parser.parse(args)
    }

    fun isAvtorization() = (res == null) and (role == null)
}

