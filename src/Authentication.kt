package com.Auten.SoftwareEngineering
import com.Main.SoftwareEngineering.*
class Params(args: Array<String>) {
    var login: String = ""
    var hash: String = ""
    var isHelp: Boolean = false

    init {
        if (args.isNotEmpty()) {
            if (args[0] == "-h")
                isHelp = true
            else {
                if ((args[0] == "-login") and (args[2] == "-pass")) {
                    login = args[1]
                    hash = getHash(args[3])
                } else if ((args[2] == "-login") and (args[0] == "-pass")) {
                    login = args[3]
                    hash = getHash(args[1])
                }
            }
        } else
            isHelp = true
    }
}

class ValidateService {
    private val pat = Regex("""[0-9a-z]+""")

    fun isLoginValid(login: String): Boolean {
        return login.matches(pat)
    }

    fun findUser(login: String): User? {
        for (user in users) {
            if (user.login == login)
                return user
        }
        return null
    }

    fun isPassCorrect(user: User, hash: String): Boolean {
        return hash.equals(user.hash)
    }
}

data class User(val login: String, val hash: String)
