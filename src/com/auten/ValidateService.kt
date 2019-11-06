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
            if ((login == access.login) and
                (isResAccess(
                        access.res.split(".").toTypedArray(),
                        res.split(".").toTypedArray()
                )
                        and (role == access.role))
            )
                return true
        }
        return false
    }

    private fun isResAccess(res1: Array<String>, res2: Array<String>): Boolean {
        return if (res1.size <= res2.size) {
            var n = 0
            for ((i, m) in res1.withIndex()) {
                if (m == res2[i])
                    n++
            }
            n == res1.size
        } else false
    }

}
