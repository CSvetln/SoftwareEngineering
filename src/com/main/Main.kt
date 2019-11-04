package com.main.softwareengineering

import kotlin.system.exitProcess
import com.auten.softwareengineering.*

fun main(args: Array<String>) {

    val par = Params(args)
    val validService = ValidateService(users, accesses)
    val us: User? = validService.findUser(par.login)
    when {
        ((us != null) and (validService.isLoginValid(par.login)) and (validService.isPassCorrect(
                us,
                par.hash,
                us?.salt
        ))) -> exitProcess(0)

        par.isHelp -> exitProcess(1)

        !validService.isLoginValid(par.login) -> exitProcess(2)

        us == null -> exitProcess(3)

        !validService.isPassCorrect(us, par.hash, us.salt) -> exitProcess(4)
    }
}


val users = listOf(
        User("admin", Hasher.getHash("admin"), "salt1"),
        User("user1", Hasher.getHash("user"), "salt2")
)
val accesses = listOf(
        Access("admin", Roles.WRITE, "АВ"),
        Access("admin", Roles.READ, "AB.C"),
        Access("User1", Roles.EXECUTE, "AB.CD.E")
)







