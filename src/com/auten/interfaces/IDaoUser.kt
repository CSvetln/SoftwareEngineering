package com.auten.interfaces

import com.auten.domain.softwareengineering.User

interface IDaoUser {
    fun findUser(login:String): User
}