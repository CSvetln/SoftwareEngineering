package com.main.softwareengineering

import com.auten.softwareengineering.*

fun main(args: Array<String>) {

    try {
        val par = Params(args)
        par.avtorization()
        par.autentification()
        par.accounting()

    } catch (e: Exception) {
        println(e.message)
    }
}


val users = listOf(
        User("admin", Hasher.getHash("admin"), "salt1"),
        User("user1", Hasher.getHash("user"), "salt2"),
        User("jdoe", Hasher.getHash("sup3rpaZZ"), "salt3"),
        User("jrow", Hasher.getHash("Qweqrty12"), "salt4"),
        User("xxx",  Hasher.getHash("yyy"), "salt5")
)
val accesses = listOf(
        Access("admin", Roles.WRITE, "AB"),
        Access("admin", Roles.READ, "AB.C"),
        Access("user1", Roles.EXECUTE, "AB.CD.E"),
        Access("John Doe", Roles.READ, "a"),
        Access("John Doe", Roles.WRITE, "a.b"),
        Access("Jane Row", Roles.EXECUTE, "a.b.c"),
        Access("John Doe", Roles.EXECUTE, "a.bc")
)







