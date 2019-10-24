class Params(args: Array<String>) {
    var login: String = ""
    var hash: String = ""
    var isHelp: Boolean = false

    init {
        if (args.isNotEmpty()) {
            when {
                args[0] == "-h" -> isHelp = true
                (args[0] == "-login") and (args[2] == "-pass") -> {
                    login = args[1]
                    hash = getHash(args[3])
                }
                (args[2] == "-login") and (args[0] == "-pass") -> {
                    login = args[3]
                    hash = getHash(args[1])
                }
            }

        } else
            isHelp = true
    }
}