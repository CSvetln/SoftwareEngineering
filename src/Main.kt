fun main(args: Array<String>) {
  /*  for(p in args){
        println(p)
    }
    print(args.size)*/
    if(args.isNullOrEmpty())
        helpOut()
    if(args[0]=="-h")
        helpOut()

    val users = listOf(User("admin", "admin"), User("user1", "user"))
    if(args.size==4) {
       if ((args[0] == "-login") and (args[2] == "-pass")) {
           for (u in users)
           if ((args[1]==u.login) and (args[3]==u.pass))
               print(0)
        }
    }
}

class Params(args: Array<String>)
{
    var login:String =""
    var pass:String=""
    var isHelp: Boolean =false

    init{
        if(args.size==4) {
            login = args[1]
            pass = args[3]
        }
        if(args[0]=="-h")
            isHelp=true

    }
}
class ValidateServise(val logins:List<String>)
{
    val pat =Regex("""[0-9a-z]+""")
    fun isLoginValid(login: String):Boolean
    {
       return login.matches(pat)
    }
    fun findUser(login: String):Boolean
    {
        for(log in logins) {
            return log == login
        }
        return false
    }
   /* fun isPassCorrect(login: String, pass: String):Boolean
    {

    }*/
}

data class User(val login:String, val pass:String)
fun helpOut() {
    println("1")
    println(
            """Приложение аутентифицирует пользователя по логину и паролю
        Коды возврата:
        0 - успех
        1 - справка  
        2 - неверный формат логина
        3 - неизвестный логин 
        4 - неправильный пароль """
    )
}