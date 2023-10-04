package ie.setu.habitat.main

import ie.setu.habitat.controllers.HabitatController
import ie.setu.habitat.models.HabitatMemStore
import ie.setu.habitat.models.HabitatModel
import mu.KotlinLogging
import ie.setu.habitat.views.HabitatView


private val logger = KotlinLogging.logger {}

//var habitat = HabitatModel()
//val habitats = ArrayList<HabitatModel>()
val habitats = HabitatMemStore()
val habitatView = HabitatView()
val controller = HabitatController()
// private var latitude: Double? = latitudeString.toDouble()
// private var longitude: Double? = longitudeString.toDouble()


fun main(args: Array<String>) {
    HabitatController().start()
}

    /*logger.info { "Launching Habitat Console App" }
    println("Habitat Kotlin App Version 3.0")

    var input: Int

    do {
        input = habitatView.menu()
        when(input) {
            1 -> addHabitat()
            2 -> updateHabitat()
            3 -> habitatView.listHabitats(habitats)
            4 -> searchHabitat()
            -99 -> dummyData()
           -1 -> exitHabitatMenu()
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Habitat Console App" }
}*/

/*fun menu() : Int {

    var option : Int
    var input: String? = null

    println("MAIN MENU")
    println(" 1. Add Habitat")
    println(" 2. Update Habitat")
    println(" 3. List all Habitats")
    println(" 4. Search Habitats")
    println("-1. Exit")
    println()
    print("Enter an option : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}*/

/*fun addHabitat() {
    // var habitatType: String
    // var latitudeString: String
    // var longitudeString: String
    val aHabitat = HabitatModel()
    if (habitatView.addHabitatData(aHabitat))
        habitats.create(aHabitat)
    else
        logger.info("Placemark Not Added")
*/
   /* println("Add Habitat")
    println()
    print("Enter a Habitat Type: ")
    aHabitat.habitatType = readln()
    println("Enter a latitude number e.g. 1.2")
    aHabitat.latitudeString = readln()
    println("Enter a longitude number e.g. 3.4")
    aHabitat.longitudeString = readln()
    val latitude: Double? = aHabitat.latitudeString?.toDouble()
    val longitude: Double? = aHabitat.longitudeString?.toDouble()*/

   /* if (latitude != null && longitude != null) {
        println("You entered: [ " + aHabitat.habitatType + "] for Habitat Type. You entered: [ $latitude ] for latitude and you entered: $longitude for longitude!")
    } else
        println("Invalid latitude & longitude input")*/

//    if (aHabitat.habitatType.isNotEmpty() && aHabitat.latitudeString.isNotEmpty() && aHabitat.longitudeString.isNotEmpty()) {
//        aHabitat.id = habitats.size.toLong()
//        habitats.add(aHabitat.copy())
//        logger.info("Habitat added : [" + aHabitat.habitatType + "]")
//    } else
//        logger.info("Habitat Type not Added")


   /* fun updateHabitat() {*/
   /*     println("Update a Habitat")
        println()
        listHabitats()

    */
        //link to search functionality
/*        habitatView.listHabitats(habitats)
        var searchId = habitatView.getId()
        val aHabitat = search(searchId)

       *//* var tempHabitatType: String?
        var tempLatitude: String?
        var tempLongitude: String?*//*

        if (aHabitat != null) {
            if (habitatView.updateHabitatData(aHabitat)) {
                habitats.update(aHabitat)
                habitatView.showHabitat((aHabitat))
                logger.info("Habitat Updated : [ $aHabitat ]")
            } else logger.info("Habitat Not Updated")
        }
        else println("Habitat Not Updated.....")
        }*/
           /* println("Enter a new Habitat Type for [ " + aHabitat.habitatType + " ] : ")
            tempHabitatType = readln()
            println("Enter a new latitude for [ " + aHabitat.latitudeString + " ] : ")
            tempLatitude = readln()
            println("Enter a new longitude for [ " + aHabitat.longitudeString + " ] : ")
            tempLongitude = readln()
            val latitude: Double? = tempLatitude.toDouble()
            val longitude: Double? = tempLongitude.toDouble()

            if (!tempHabitatType.isNullOrEmpty() && !tempLatitude.isNullOrEmpty() && !tempLongitude.isNullOrEmpty()) {
                aHabitat.habitatType = tempHabitatType
                aHabitat.latitudeString = tempLatitude
                aHabitat.longitudeString = tempLongitude
                println(
                    "You updated [ " + aHabitat.habitatType + " ] for Habitat Type " +
                            "and [$latitude] for latitude " +
                            "and [$longitude] for longitude"
                )
            } else {
                logger.info("Habitat Not Updated")
            }
        }*/


      /*  fun listHabitats() {
            println("You chose to List all Habitat Types")
            println()
            habitats.forEach { logger.info("${it}") }
            println()
        }*/

   /*     fun exitHabitatMenu() {
            println("Exiting Habitat Menu")
        }

        fun searchHabitat() {
            val aHabitat = search(habitatView.getId())!!
            habitatView.showHabitat(aHabitat)
*/
            /*var searchId = getId()
            val aHabitat = search(searchId)

            if(aHabitat != null)
                println("Habitat Details [$aHabitat]")
            else
                println("Habitat not found...")*/


     /*   fun search(id: Long): HabitatModel? {
            var foundHabitat = habitats.findOne(id)
            return foundHabitat
//            var foundHabitat: HabitatModel? =
//                habitats.find { h -> h.id == id }
//            return foundHabitat

        }
*/
     /*   fun getId(): Long {
            var strId: String? // String to hold user input
            var searchId: Long // Long to hold converted id
            print("Enter id to Search/Update : ")
            strId = readLine()!!
            searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
                strId.toLong()
            else
                -9
            return searchId
        }*/

      /*  fun dummyData() {
            habitats.create(HabitatModel(1,"Garden", "1.2", "2.3"))
            habitats. create(HabitatModel(2, "Field", "3.4","4.5"))
            habitats.create(HabitatModel(3,"Hedgerow", "6.7","7.8"))
        }
*/
