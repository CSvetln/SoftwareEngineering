class ValidateService {
    private val pat = Regex("[0-9a-z]+")

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

    fun isPassCorrect(user: User?, hash: String): Boolean {
        return hash == user?.hash
    }
}