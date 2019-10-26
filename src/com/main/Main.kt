package com.main.softwareengineering

import java.security.MessageDigest
import kotlin.experimental.and
import kotlin.system.exitProcess
import com.auten.softwareengineering.*

fun main(args: Array<String>) {

    val par = Params(args)
    val validService = ValidateService(users)
    val us: User? = validService.findUser(par.login)
    when {
        ((us != null) and (validService.isLoginValid(par.login)) and (validService.isPassCorrect(
                us,
                par.hash
        ))) -> exitProcess(0)

        par.isHelp -> exitProcess(1)

        !validService.isLoginValid(par.login) -> exitProcess(2)

        us == null -> exitProcess(3)

        !validService.isPassCorrect(us, par.hash) -> exitProcess(4)
    }
}

val users = listOf(User("admin", getHash("admin")), User("user1", getHash("user")))

fun getHash(pass: String): String {

    val md = MessageDigest.getInstance("MD5")
    md.update(pass.toByteArray());
    val byteData: ByteArray = md.digest();
    val sb = StringBuffer()
    for (aByteData in byteData) {
        sb.append(((aByteData and 0xff.toByte()) + 0x100).toString(16).substring(1)) //переводим в шестнадцитиричную сс
    }
    return sb.toString()// возращаем хеш в строковом виде
}




