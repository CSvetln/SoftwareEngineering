fun main(args: Array<String>) {
    val str : String
    var words = args
    if (args.isNullOrEmpty()) {
        str = readLine().toString()
        words = str.split(" ").toTypedArray()
    }

    words = words.sorted().toTypedArray()

    val uniWords = words.distinct().toTypedArray()

    var count = 0
    for (i in 0 until uniWords.size) {
        for (j in 0 until words.size) {
            if (uniWords[i] == words[j])
                count ++
        }

        println(uniWords[i] + " " + count)
        count = 0
    }

}
