package com.auten.service.softwareengineering

import com.auten.domain.softwareengineering.Access
import com.auten.domain.softwareengineering.Roles

class AuthorisationService(private val listAccesses: List<Access>) {

    fun isUserHasRole(login: String, role: Roles, res: String) = listAccesses.any { accessExist(login, it, res, role) }

    private fun accessExist(
        login: String,
        access: Access,
        res: String,
        role: Roles
    ) = (login == access.login) and isResAccess(access.res, res) and (role == access.role)

    private fun isResAccess(res1: String, res2: String) = isResAccess(
            res1.split('.').toTypedArray(),
            res2.split('.').toTypedArray()
    )


    private fun isResAccess(res1: Array<String>, res2: Array<String>): Boolean {
        return if (res1.size > res2.size)
            false
        else {
            for ((i, m) in res1.withIndex()) {
                if (m != res2[i])
                    return false
            }
            true
        }
    }
}