package com.auten.service.softwareengineering

import com.auten.domain.softwareengineering.User

class AuthenticationService(private val listUsers: List<User>) {
    private val pat = Regex("[0-9A-Za-z]+")

     fun isLoginValid(login: String) = login.matches(pat)


    fun findUser(login: String) = listUsers.find { it.login == login }


    fun isPassCorrect(user: User, pass: String) =
        Hasher.getHash(Hasher.getHash(pass) + user.salt) == Hasher.getHash(user.hash + user.salt)
}