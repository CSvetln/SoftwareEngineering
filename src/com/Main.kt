package com.softwareengineering

import com.auten.domain.softwareengineering.*
import com.auten.interfaces.softwareengineering.IParse
import com.auten.service.softwareengineering.*
import org.flywaydb.core.Flyway
import java.sql.DriverManager


fun main(args: Array<String>) {

    try {
        val flyway = Flyway.configure().dataSource("jdbc:h2:file:./aaa", "SS", null).load()
        flyway.migrate()
        val conn = DriverManager.getConnection("jdbc:h2:file:./aaa", "SS", null)
        val par: IParse = ConsoleParams(args)
        val enter = EnterService(par)
        val authen = AuthenticationService(users)
        val author = AuthorisationService(accesses)
        val account = AccountingService()
        enter.authentication(authen)
        enter.authorisation(author)
        enter.accounting(account)
        conn.close()

    } catch (e: Exception) {
        println(e.message)
    }
}


val users = listOf(
    User("admin", Hasher.getHash("admin"), "salt1"),
    User("user1", Hasher.getHash("user"), "salt2"),
    User("jdoe", Hasher.getHash("sup3rpaZZ"), "salt3"),
    User("jrow", Hasher.getHash("Qweqrty12"), "salt4"),
    User("xxx", Hasher.getHash("yyy"), "salt5")
)
val accesses = listOf(
    Access("admin", Roles.WRITE, "AB"),
    Access("admin", Roles.READ, "AB.C"),
    Access("admin", Roles.READ, "A.B.C"),
    Access("user1", Roles.EXECUTE, "AB.CD.E"),
    Access("jdoe", Roles.READ, "A"),
    Access("jdoe", Roles.WRITE, "A.B"),
    Access("jrow", Roles.EXECUTE, "A.B.C"),
    Access("jdoe", Roles.EXECUTE, "A.BC"),
    Access("admin", Roles.READ, "AB"),
    Access("admin", Roles.READ, "A")
)







