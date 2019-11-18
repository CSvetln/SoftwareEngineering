package com.auten.softwareengineering

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class ValidateService(private val listUsers: List<User>, private val listAccesses: List<Access>) {

    private val pat = Regex("[0-9a-z]+")

    fun isLoginValid(login: String) = login.matches(pat)


    fun findUser(login: String) = listUsers.find { it.login == login }


    fun isPassCorrect(user: User, pass: String) =
        Hasher.getHash(Hasher.getHash(pass) + user.salt) == Hasher.getHash(user.hash + user.salt)

    fun isUserHasRole(login: String, role: Roles, res: String): Boolean {
        for (access in listAccesses) {
            if (accessExist(login, access, res, role))
                return true
        }
        return false
    }

    private fun accessExist(
        login: String,
        access: Access,
        res: String,
        role: Roles
    ) = (login == access.login) and isResAccess(access.res, res) and (role == access.role)

    private fun isResAccess(res1: String, res2: String) = isResAccess(
            res1.split('.').toTypedArray(),
            res2.split('.').toTypedArray()
    )


    private fun isResAccess(res1: Array<String>, res2: Array<String>): Boolean {
        return if (res1.size > res2.size)
        false
        else {
            for ((i, m) in res1.withIndex()) {
                if (m != res2[i])
                    return false
            }
            true
        }
    }

    fun isDateValid(date:String):Boolean
    {
        val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return try {
            LocalDate.parse(date, format)
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }


}
