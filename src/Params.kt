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
            args[0] == "-h" -> {
                isHelp = true
                login = ""
                hash = ""
            }
            (args[0] == "-login") and (args[2] == "-pass") -> {
                login = args[1]
                hash = getHash(args[3])
                isHelp = false
            }
            (args[2] == "-login") and (args[0] == "-pass") -> {
                login = args[3]
                hash = getHash(args[1])
                isHelp = false
            }
            else -> {
                login = ""
                hash = ""
                isHelp = false
            }
        }
    }
}
