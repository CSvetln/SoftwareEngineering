package com.main.softwareengineering

import kotlin.system.exitProcess
import com.auten.softwareengineering.*

fun main(args: Array<String>) {

    val par = Params(args)
    val validService = ValidateService(users)
    val us: User? = validService.findUser(par.login)

    when {
        ((us != null) and (validService.isLoginValid(par.login)) and (validService.isPassCorrect(
                us,
                par.hash
        ))) -> exitProcess(0)

        par.isHelp -> exitProcess(1)

        !validService.isLoginValid(par.login) -> exitProcess(2)

        us == null -> exitProcess(3)

        !validService.isPassCorrect(us, par.hash) -> exitProcess(4)
    }
}


val users = listOf(
        User("admin", Hasher.getHash("admin")),
        User("user1", Hasher.getHash("user"))
)







