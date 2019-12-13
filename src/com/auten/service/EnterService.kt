package com.auten.service.softwareengineering

import com.auten.domain.softwareengineering.Roles
import com.auten.domain.softwareengineering.User
import com.auten.interfaces.softwareengineering.IParse
import org.apache.logging.log4j.LogManager
import kotlin.system.exitProcess

private val logger = LogManager.getLogger(EnterService::class.java)

class EnterService(private val par: IParse) {

    fun accounting(account: AccountingService) {
        if (par.args.size != 14)
            return
        else {
            when {
                !account.isDateValid(par.ds) -> {
                    logger.info("Date ${par.ds} is not valid")
                    exitProcess(7)}
                !account.isDateValid(par.de) ->{
                    logger.info("Date ${par.ds} is not valid")
                    exitProcess(7)}
                !account.isVolValid(par.vol) -> {
                    logger.info("Volume ${par.vol} is not valid")
                    exitProcess(7)}
            }
        }
    }


    fun authentication(authen: AuthenticationService) {
        if (par.args.size < 4)
            exitProcess(0)
        else if (par.args.size >= 4) {
            val us: User? = authen.findUser(par.login)
            when {
                par.isHelp -> exitProcess(0)

                !authen.isLoginValid(par.login) -> {
                    logger.info("Login ${par.login} is not valid")
                    exitProcess(2)
                }

                us == null -> {
                    logger.info("User ${par.login} does not exist")
                    exitProcess(3)
                }

                !authen.isPassCorrect(us, par.pass) -> {
                    logger.info("For user ${us.login} password ${par.pass} is not correct")
                    exitProcess(4)
                }

            }
        }
    }

    fun authorisation(author: AuthorisationService) {
        if (par.args.size < 8)
            return
        else {
            when {
                !Roles.isRoleExist(par.role) -> {
                    logger.info("Role ${par.role} does not exist")
                    exitProcess(5)
                }

                !author.isUserHasRole(par.login, Roles.valueOf(par.role), par.res) -> {
                    logger.info("User ${par.login} does not have access to the resource ${par.res} by role ${par.role}")
                    exitProcess(6)
                }
            }
        }
    }
}