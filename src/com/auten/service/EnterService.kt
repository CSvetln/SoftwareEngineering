package com.auten.service.softwareengineering

import com.auten.domain.softwareengineering.Roles
import com.auten.domain.softwareengineering.User
import com.auten.interfaces.softwareengineering.IParse
import kotlin.system.exitProcess

class EnterService(private val par: IParse) {

    fun accounting(account: AccountingService) {
        if (par.args.size != 14)
            return
        else {
            when {
                !account.isDateValid(par.ds) -> exitProcess(7)
                !account.isDateValid(par.de) -> exitProcess(7)
                !account.isVolValid(par.vol) -> exitProcess(7)
            }
        }
    }


    fun authentication(authen: AuthenticationService) {
        if (par.args.size < 4)
            exitProcess(1)
        else if (par.args.size >= 4) {
            val us: User? = authen.findUser(par.login)
            when {
                par.isHelp -> exitProcess(1)

                !authen.isLoginValid(par.login) -> exitProcess(2)

                us == null -> exitProcess(3)

                !authen.isPassCorrect(us, par.pass) -> exitProcess(4)

            }
        }
    }

    fun authorisation(author: AuthorisationService) {
        if (par.args.size < 8)
            return
        else {
            when {
                !Roles.isRoleExist(par.role) -> exitProcess(5)

                !author.isUserHasRole(par.login, Roles.valueOf(par.role), par.res) -> exitProcess(6)
            }
        }
    }
}