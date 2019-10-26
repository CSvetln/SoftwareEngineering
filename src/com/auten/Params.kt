package com.auten.softwareengineering

import com.main.softwareengineering.getHash

class Params(args: Array<String>) {
    val login: String
    val hash: String
    val isHelp: Boolean

    init {
        when {
            args.isNullOrEmpty() -> {
                isHelp = true
                login = ""
                hash = ""
            }
            (args.size == 1) and (args[0] == "-h") -> {
                isHelp = true
                login = ""
                hash = ""
            }
            (args.size == 4) -> {
                if (isForward(args)) {
                    login = args[1]
                    hash = getHash(args[3])
                    isHelp = false
                } else {
                    login = args[3]
                    hash = getHash(args[1])
                    isHelp = false
                }
            }
            else -> {
                login = ""
                hash = ""
                isHelp = true
            }
        }
    }

    private fun isForward(args: Array<String>): Boolean {
        return when {
            (args[0] == "-login") and (args[2] == "-pass") -> true
            (args[2] == "-login") and (args[0] == "-pass") -> false
            else -> false
        }
    }
}

