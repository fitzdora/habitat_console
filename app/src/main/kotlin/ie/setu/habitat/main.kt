package ie.setu.habitat

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    logger.info { "Launching Habitat Console App" }
    println("Habitat Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addHabitat()
            2 -> updateHabitat()
            3 -> listHabitat()
            -1 -> exitHabitatMenu()
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Habitat Console App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add Habitat")
    println(" 2. Update Habitat")
    println(" 3. List All Habitats")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addHabitat(){
    println("You chose to add a Habitat")
}
fun updateHabitat(){
    println("You chose to update a Habitat")
}

fun listHabitat(){
    println("You chose to List all Placemarks")
}

fun exitHabitatMenu(){
    println("Exiting Habitat Menu")
}
