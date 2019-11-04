package com.auten.softwareengineering

class ValidateService(_listUsers: List<User>, _listAccesses: List<Access>) {
    private val listUsers = _listUsers
    private val listAccesses = _listAccesses

    private val pat = Regex("[0-9a-z]+")

    fun isLoginValid(login: String): Boolean {
        return login.matches(pat)
    }

    fun findUser(login: String): User? {
        for (user in listUsers) {
            if (user.login == login)
                return user
        }
        return null
    }

    fun isPassCorrect(user: User?, hash: String, salt: String?): Boolean {
        return Hasher.getHash(hash + salt) == Hasher.getHash(user?.hash + salt);
    }

    fun isRoleExist(role: String): Boolean {
        for (rol in Roles.values()) {
            if (rol.toString() == role)
                return true
        }
        return false
    }

    fun isUserHasRole(login: String, role: Roles, res: String): Boolean {
        for (access in listAccesses) {
            if ((login == access.login) and (role == access.role) and (res == access.res))
                return true
        }
        return false
    }
}
