package com.Auten.SoftwareEngineering
import com.Main.SoftwareEngineering.getHash

class Params(args: Array<String>) {
    var login: String = ""
    var hash: String = ""
    var isHelp: Boolean = false

    init {
        if (args.isNotEmpty()) {
            if (args[0] == "-h")
                isHelp = true
            else if ((args[0] == "-login") and (args[2] == "-pass")) {
                    login = args[1]
                    hash = getHash(args[3])
                } else if ((args[2] == "-login") and (args[0] == "-pass")) {
                    login = args[3]
                    hash = getHash(args[1])
                }

        } else
            isHelp = true
    }
}