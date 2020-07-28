import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Usage: gpio-pin-convert <pin>")
        exitProcess(-1)
    }

    val bcm = args[0].toIntOrNull()
    if (bcm == null) {
        println("No pin number given")
        exitProcess(-1)
    }

    val wpi = pinConvert(bcm)
    if (wpi == null) {
        println("Invalid pin given")
        exitProcess(-1)
    }

    println("GPIO BCM " + bcm + " => GPIO wPi " + wpi)
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