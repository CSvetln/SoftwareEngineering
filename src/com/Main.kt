package com.softwareengineering

import com.auten.DAO.UserDao
import com.auten.domain.softwareengineering.*
import com.auten.interfaces.softwareengineering.IParse
import com.auten.service.softwareengineering.*
import org.flywaydb.core.Flyway
import java.sql.DriverManager
import java.sql.ResultSet




fun main(args: Array<String>) {

    try {

        //print(Hasher.getHash("xxx"))
               val flyway = Flyway.configure().dataSource("jdbc:h2:file:./aaa", "SS", null).load()
               flyway.migrate()
        /*val conn = DriverManager.getConnection("jdbc:h2:file:./aaa", "SS", null)
        val statement = conn.createStatement()
        val rows = statement.executeUpdate("UPDATE User SET hash = 'cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860' where login = 'xxx'")
        print(rows)*/
       /* val statement = conn.prepareStatement("SELECT hash, salt FROM User WHERE login = ? ")
        statement.setString(1, "admin")

        val resultSet = statement.executeQuery()
        while (resultSet.next()) {

            print(resultSet.getString(1))
            print(resultSet.getString(2))

        }*/
     /*   val userDao = UserDao();
        val user = userDao.findUser("jrow")
        println(user.hash)
        println(user.salt)*/
        //val conn = DriverManager.getConnection("jdbc:h2:file:./aaa", "SS", null)


       /* val statement = conn.prepareStatement("SELECT * FROM User WHERE login = ? ")
        statement.setString(1, log)

        val resultSet = statement.executeQuery()
        while (resultSet.next()) {
            val login = resultSet.getString(1)
            val hash = resultSet.getString(2)
            val salt = resultSet.getString(3)
            print(login)
            print(hash)
            print(salt)
        }*/
       val par: IParse = ConsoleParams(args)
        val enter = EnterService(par)
        val authen = AuthenticationService()
        val author = AuthorisationService(accesses)
        val account = AccountingService()
        enter.authentication(authen)
        enter.authorisation(author)
        enter.accounting(account)
        //conn.close()

    } catch (e: Exception) {
        println(e.message)
    }
}
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







