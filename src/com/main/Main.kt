package com.main.softwareengineering

import kotlin.system.exitProcess
import com.auten.softwareengineering.*

fun main(args: Array<String>) {
    try {
        val par = Params(args)
        val validService = ValidateService(users, accesses)
        val us: User? = validService.findUser(par.login!!)
        when {
            par.isHelp!! -> exitProcess(1)

            !validService.isLoginValid(par.login!!) -> exitProcess(2)

            us == null -> exitProcess(3)

            !validService.isPassCorrect(us, par.hash!!, us.salt) -> exitProcess(4)

            !par.isAvtorization() and !isRoleExist(par.role!!) -> exitProcess(5)

            isRoleExist(par.role!!) ->
                if (!par.isAvtorization() and !validService.isUserHasRole(
                            par.login!!,
                            Roles.valueOf(par.role!!),
                            par.res!!
                    )
                )
                    exitProcess(6)

            else -> exitProcess(0)

        }
    } catch (e: Exception) {
        println(e.message)
    }
}

val users = listOf(
        User("admin", Hasher.getHash("admin"), "salt1"),
        User("user1", Hasher.getHash("user"), "salt2")
)
val accesses = listOf(
        Access("admin", Roles.WRITE, "AB"),
        Access("admin", Roles.READ, "AB.C"),
        Access("user1", Roles.EXECUTE, "AB.CD.E")
)







