import kotlin.system.exitProcess

fun main(args: Array<String>) {
    
    var pinIn: Int?
    var method: String?
    var converter: (Int) -> Int?    

    if (args.size == 2 && args[0] == "-r") {
        pinIn = args[1].toIntOrNull()
        method = "wPi -> BCM"
        converter = ::pinConvertReverse
    } else if (args.size == 1) {
        pinIn = args[0].toIntOrNull()
        method = "BCM -> wPi"
        converter = ::pinConvert
    } else {
        println("Usage: gpio-pin-convert [-r] <pin>")
        exitProcess(-1)
    }

    if (pinIn == null) {
        println("No pin number given")
        exitProcess(-1)
    }

    val pinOut = converter(pinIn)
    if (pinOut == null) {
        println("Invalid pin given")
        exitProcess(-1)
    }

    println(method + ": " + pinIn + " -> " + pinOut)
}

fun pinConvertReverse(wPi: Int) = when (wPi) {
    8 -> 2
    9 -> 3
    7 -> 4
    0 -> 17
    2 -> 27
    3 -> 22
    12 -> 10
    13 -> 9
    14 -> 11
    30 -> 0
    21 -> 5
    22 -> 6
    23 -> 13
    24 -> 19
    25 -> 26
    15 -> 14
    16 -> 15
    1 -> 18
    4 -> 23
    5 -> 24
    6 -> 25
    10 -> 8
    11 -> 7
    31 -> 1
    26 -> 12
    27 -> 16
    28 -> 20
    29 -> 21
    else -> null
}

fun pinConvert(bcm: Int) = when (bcm) {
    2 -> 8
    3 -> 9
    4 -> 7
    17 -> 0
    27 -> 2
    22 -> 3
    10 -> 12
    9 -> 13
    11 -> 14
    0 -> 30
    5 -> 21
    6 -> 22
    13 -> 23
    19 -> 24
    26 -> 25
    14 -> 15
    15 -> 16
    18 -> 1
    23 -> 4
    24 -> 5
    25 -> 6
    8 -> 10
    7 -> 11
    1 -> 31
    12 -> 26
    16 -> 27
    20 -> 28
    21 -> 29
    else -> null
}
