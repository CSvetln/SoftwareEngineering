package com.auten.domain.softwareengineering

import com.auten.interfaces.softwareengineering.IParse
import kotlinx.cli.*
import java.lang.Exception
import kotlin.system.exitProcess

class ConsoleParams(override val args: Array<String>) : IParse {
    override val isHelp: Boolean
    private val parser = ArgParser("example")
    override val login by parser.option(ArgType.String, shortName = "login").default(" ")
    override val pass by parser.option(ArgType.String, shortName = "pass").default(" ")
    override val res by parser.option(ArgType.String, shortName = "res").default(" ")
    override val role by parser.option(ArgType.String, shortName = "role").default(" ")
    override val ds by parser.option(ArgType.String, shortName = "ds").default(" ")
    override val de by parser.option(ArgType.String, shortName = "de").default(" ")
    override val vol by parser.option(ArgType.String, shortName = "vol").default(" ")

    init {
        try {
            parser.parse(args)
        } catch (e: IllegalStateException) {
            exitProcess(1)
        }
        isHelp = args.isNullOrEmpty() or (args.size == 1) or (login=="") or (pass=="")


    }
}

