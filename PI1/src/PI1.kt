public fun main(args: Array<String>){
    var str:String
    var words = args
    if(args.isNullOrEmpty()) {
        str = readLine().toString()
        words=str.split(" ").toTypedArray()
    }

    words= Sort(words)

    val uniWords= words.distinct().toTypedArray()

    var count =0
    for (i in 0 until uniWords.size) {
        for (j in 0 until words.size) {
            if (uniWords[i] == words[j])
                count++
        }

        println(uniWords[i] + " " + count)
        count = 0
    }

}
fun out(arr: Array<String>){
    for(el in arr) {
        if (el.isNotEmpty())
            println(el)
    }
}
fun Sort(arr: Array<String>): Array<String>{
    var temp: String
    var flag : Boolean
    do {
        flag = false
        for (i in 0..arr.size - 2){
            if (arr[i] > arr[i + 1]){
                temp=arr[i]
                arr[i]=arr[i+1]
                arr[i+1]=temp
                flag = true
            }
        }
    } while (flag)
    return arr
}