package ie.setu.habitat.views

import ie.setu.habitat.models.HabitatMemStore
import ie.setu.habitat.models.HabitatModel

class HabitatView {
    fun menu(): Int {

        var option: Int
        var input: String? = null

        println("MAIN MENU")
        println(" 1. Add Habitat")
        println(" 2. Update Habitat")
        println(" 3. List all Habitats")
        println(" 4. Search Habitats")
        println(" 5. Delete Habitats")
        println("-1. Exit")
        println()
        print("Enter an option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listHabitats(habitats: HabitatMemStore) {
        println("You chose to List all Habitat Types")
        println()
        habitats.logAll()
        println()
    }

    fun showHabitat(habitat: HabitatModel) {
        if (habitat != null)
            println("Habitat Details [ $habitat ]")
        else
        println("Habitat Not Found")
    }

    fun addHabitatData(habitat: HabitatModel): Boolean {

        print("Enter a Habitat Type: ")
        habitat.habitatType = readln()
        println("Enter a latitude number e.g. 1.2")
        habitat.latitudeString = readln()
        println("Enter a longitude number e.g. 3.4")
        habitat.longitudeString = readln()
        //checking data conversion before moving further to MVC
        //this input should be eventually provided by the images
        //needs more work later as storing invalid data and empty string is giving exit code 1
        val latitude: Double? = habitat.latitudeString?.toDouble()
        println("Latitude as Double: $latitude")
        val longitude: Double? = habitat.longitudeString?.toDouble()
        println("Longitude as Double: $longitude")
        //setting more validation for datatype lon/lat
        if (latitude != null && longitude !=null)
            if(latitude in -90.0..90.0 && longitude in -180.0..180.0) {
                habitat.latitudeString = latitude.toString()
                habitat.latitudeString = longitude.toString()
            } else {
                println("Invalid latitude or longitude range.")
            } else {
                println("Invalid latitude or longitude format")
        }


        return habitat.habitatType.isNotEmpty() && habitat.latitudeString.isNotEmpty() && habitat.longitudeString.isNotEmpty()
    }

    fun updateHabitatData(habitat: HabitatModel): Boolean {

        val tempHabitatType: String?
        val tempLatitude: String?
        val tempLongitude: String?


        if (habitat != null) {
            println("Enter a new Habitat Type for [ " + habitat.habitatType + " ] : ")
            tempHabitatType = readln()
            println("Enter a new latitude for [ " + habitat.latitudeString + " ] : ")
            tempLatitude = readln()
            println("Enter a new longitude for [ " + habitat.longitudeString + " ] : ")
            tempLongitude = readln()
            val latitude: Double? = tempLatitude.toDouble()
            val longitude: Double? = tempLongitude.toDouble()

            if (!tempHabitatType.isNullOrEmpty() && !tempLatitude.isNullOrEmpty() && !tempLongitude.isNullOrEmpty()) {
                habitat.habitatType = tempHabitatType
                habitat.latitudeString = tempLatitude
                habitat.longitudeString = tempLongitude
                return true
            }
        }
        return false
    }

    fun getId(): Long {
        var strId: String? // String to hold user input
        var searchId: Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

}