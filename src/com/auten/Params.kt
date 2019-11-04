package com.auten.softwareengineering

class Params(args: Array<String>) {
    val login: String
    val hash: String
    val isHelp: Boolean
    val res: String
    val role: String

    init {
        when {
            args.isNullOrEmpty() -> {
                isHelp = true
                login = ""
                hash = ""
                res = ""
                role = ""
            }
            (args.size == 1) and (args[0] == "-h") -> {
                isHelp = true
                login = ""
                hash = ""
                res = ""
                role = ""
            }
            (args.size >= 4) and (args.size < 8) and (args.contains("-login")) and (args.contains("-pass")) -> {
                login = args[args.indexOf("-login") + 1]
                hash = Hasher.getHash(args[args.indexOf("-pass") + 1])
                isHelp = false
                res = ""
                role = ""
            }
            (args.contains("-login")) and (args.contains("-pass")) and (args.contains("-res")) and (args.contains("-role")) -> {
                login = args[args.indexOf("-login") + 1]
                hash = Hasher.getHash(args[args.indexOf("-pass") + 1])
                isHelp = false
                res = args[args.indexOf("-res") + 1]
                role = args[args.indexOf("-role") + 1]
            }
            else -> {
                login = ""
                hash = ""
                isHelp = true
                role = ""
                res = ""
            }
        }
    }
}

