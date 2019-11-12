package com.auten.softwareengineering

import com.main.softwareengineering.accesses
import com.main.softwareengineering.users
import kotlinx.cli.*

class Params(private val args: Array<String>) {
    private val isHelp: Boolean
    private val parser = ArgParser("example")
    private val login by parser.option(ArgType.String, shortName = "login").default(" ")
    private val pass by parser.option(ArgType.String, shortName = "pass").default(" ")
    private val res by parser.option(ArgType.String, shortName = "res").default(" ")
    private val role by parser.option(ArgType.String, shortName = "role").default(" ")

    init {
        parser.parse(args)
        isHelp = args.isNullOrEmpty() or (args.size == 1)
    }

    private val validService = ValidateService(users, accesses)

    fun avtorization(): Int {
        return if (args.size < 4)
            1
        else {
            val us: User? = validService.findUser(login)
            when {
                isHelp -> 1

                !validService.isLoginValid(login) -> 2

                us == null -> 3

                !validService.isPassCorrect(us, pass) -> 4

                else -> 0
            }
        }
    }

    fun autentification(): Int {
        return if (args.size != 8)
            0
        else {
            when {
                !Roles.isRoleExist(role) -> 5

                !validService.isUserHasRole(login, Roles.valueOf(role), res) -> 6

                else -> 0
            }
        }
    }
}

