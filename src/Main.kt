import java.security.MessageDigest
import kotlin.experimental.and
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    try {

        val par = Params(args)
        val validService = ValidateService()

        if (par.isHelp)
            helpOut()
        else if (!validService.isLoginValid(par.login))
            exitProcess(2)
        else {
            val us: User = validService.findUser(par.login)!!

            if (validService.isPassCorrect(us, par.hash))
                exitProcess(0)
            else
                exitProcess(4)
        }

    } catch (e: KotlinNullPointerException) {
        exitProcess(3)
    }
}


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

val users = listOf(User("admin", getHash("admin")), User("user1", getHash("user")))


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

fun getHash(pass: String): String {

    val md = MessageDigest.getInstance("MD5")
    md.update(pass.toByteArray());
    val byteData: ByteArray = md.digest();
    val sb = StringBuffer()
    for (aByteData in byteData) {
        sb.append(Integer.toString((aByteData and 0xff.toByte()) + 0x100, 16).substring(1))
    }
    return sb.toString()
}

data class User(val login: String, val hash: String)

fun helpOut() {
    exitProcess(1)
}
