package ie.setu.habitat.main

import ie.setu.habitat.models.HabitatModels
import mu.KotlinLogging


private val logger = KotlinLogging.logger {}

var habitat = HabitatModels()
// private var latitude: Double? = latitudeString.toDouble()
// private var longitude: Double? = longitudeString.toDouble()


fun main(args: Array<String>) {
    logger.info { "Launching Habitat Console App" }
    println("Habitat Kotlin App Version 2.0")

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

fun addHabitat() {
    // var habitatType: String
   // var latitudeString: String
   // var longitudeString: String


    println("Add Habitat")
    println()
    print("Enter a Habitat Type: ")
    habitat.habitatType = readln()
    println("Enter a latitude number")
    habitat.latitudeString = readln()
    println("Enter a longitude number")
    habitat.longitudeString = readln()
    val latitude: Double? = habitat.latitudeString?.toDouble()
    val longitude: Double? = habitat.longitudeString?.toDouble()
    if (latitude != null && longitude != null) {
        println("You entered: [ " + habitat.habitatType + "] for Habitat Type. You entered: [ $latitude ] for latitude and you entered: $longitude for longitude!")
    } else
        println("Invalid latitude & longitude input")
}

fun updateHabitat() {
    println("Update a Habitat")
    println()
    println("Enter a new Habitat Type for [ " + habitat.habitatType + " ] : ")
    habitat.habitatType = readln()
    println("Enter a new latitude for [ " + habitat.latitudeString + " ] : ")
    habitat.latitudeString = readln()
    println("Enter a new longitude for [ " + habitat.longitudeString + " ] : ")
    habitat.longitudeString = readln()
    val latitude: Double? = habitat.latitudeString?.toDouble()
    val longitude: Double? = habitat.longitudeString?.toDouble()
    println("You updated [ " + habitat.habitatType + " ] for Habitat Type and [$latitude] for latitude and [$longitude] for longitude")
}


fun listHabitat() {
    println("You chose to List all Placemarks")
}

fun exitHabitatMenu() {
    println("Exiting Habitat Menu")
}
