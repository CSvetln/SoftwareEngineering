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
fun main(args: Array<String>) {
    if(args.isEmpty())
        helpOut()
    if ((args.isNotEmpty()) and (args[0]=="-h"))
        helpOut()
}
