package com.auten.DAO

import com.auten.domain.softwareengineering.User
import com.auten.interfaces.IDaoUser
import java.sql.DriverManager
import java.util.ArrayList



class UserDao: IDaoUser {
    val conn = DriverManager.getConnection("jdbc:h2:file:./aaa", "SS", null)


    private val users = ArrayList<User>()

    override fun findUser(login:String):User {

        val statement = conn.prepareStatement("SELECT hash, salt FROM User WHERE login = ? ")
        statement.setString(1, login)

        val resultSet = statement.executeQuery()
        var hash:String=""
        var salt:String=""
        while (resultSet.next()) {

            hash = resultSet.getString(1)
            salt = resultSet.getString(2)

       }
        return User(
            login,
            hash,
            salt
        )
    }


}
