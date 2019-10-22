fun main(args: Array<String>) {
    try {

        //val str = readLine().toString()
       // val args1 = str.split(" ").toTypedArray()
        val par = Params(args)
        val validService = ValidateService()

        if(par.isHelp)
            helpOut()
        else {
            if(!validService.isLoginValid(par.login))
                println(2)
            else{
                val us: User = validService.findUser(par.login)!!
                if (validService.isPassCorrect(us, par.pass))
                    println(0)
                else
                    println(4)
            }
        }
    }
    catch (e: KotlinNullPointerException)
    {
        println(3)
    }
}


class Params(args: Array<String>) {
    var login: String = ""
    var pass: String = ""
    var isHelp: Boolean = false

    init {
        if(args.isNotEmpty()) {
            if (args[0] == "-h")
                isHelp = true
            else {
                if ((args[0] == "-login") and (args[2] == "-pass")) {
                    login = args[1]
                    pass = args[3]
                }
                else if ((args[2] == "-login") and (args[0] == "-pass")) {
                    login = args[3]
                    pass = args[1]
                }
            }
        }
        else
            isHelp = true
    }
}

val users = listOf(User("admin", "admin"), User("user1", "user"))

class ValidateService {
    private val pat =Regex("""[0-9a-z]+""")

    fun isLoginValid(login: String):Boolean
    {
       return login.matches(pat)
    }

    fun findUser(login: String):User?
    {
        for(user in users) {
           if(user.login==login)
               return user
            }
        return null
    }

    fun isPassCorrect(user:User, pass: String):Boolean
    {
      return pass==user.pass
    }

}

data class User(val login:String, val pass:String)

fun helpOut() {
    println("1")
   /* println(
            """Приложение аутентифицирует пользователя по логину и паролю
        Коды возврата:
        0 - успех
        1 - справка  
        2 - неверный формат логина
        3 - неизвестный логин 
        4 - неправильный пароль """
    )*/
}