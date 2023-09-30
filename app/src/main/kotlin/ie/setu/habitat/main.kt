package ie.setu.habitat

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    logger.info { "Launching Habitat Console App" }
    println("Habitat Kotlin App Version 1.0")

    var input: Int
    input = menu()

}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Habitat")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = input.toInt()

    return option
}