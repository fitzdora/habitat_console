package ie.setu.habitat.controllers


import ie.setu.habitat.models.HabitatMemStore
import mu.KotlinLogging
import ie.setu.habitat.models.HabitatModel
import ie.setu.habitat.views.HabitatView

class HabitatController {
    val habitats = HabitatMemStore()
    // val habitats = HabitatJSONStore()

    val habitatView = HabitatView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Habitat Console App" }
        println(" Habitat Kotlin app Version 1.5")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                // -99 -> dummyData()
                -1 -> exit()
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Habitat Console App" }

    }

    fun menu(): Int {
        return habitatView.menu()
    }

    fun add() {
        val aHabitat = HabitatModel()
        if (habitatView.addHabitatData(aHabitat))
            habitats.create(aHabitat)
        else
            logger.info("Habitat Not Added")
    }

    fun list() {
        habitatView.listHabitats(habitats)
    }

    fun update() {
        habitatView.listHabitats(habitats)
        val searchId = habitatView.getId()
        val aHabitat = search(searchId)

        if (aHabitat != null) {
            if (habitatView.updateHabitatData(aHabitat)) {
                habitats.update(aHabitat)
                habitatView.showHabitat(aHabitat)
                logger.info("Habitat Updated : [$aHabitat]")
            } else
                logger.info("Habitat not updated")
        } else
            println("Habitat not updated...")
    }

    fun search() {
        val aHabitat = search(habitatView.getId())!!
        habitatView.showHabitat(aHabitat)
    }

    fun search(id: Long): HabitatModel? {
        val foundHabitat = habitats.findOne(id)
        return foundHabitat
    }

    fun delete() {
        habitatView.listHabitats(habitats)
        var searchId = habitatView.getId()
        val aHabitat = search(searchId)

        if (aHabitat != null) {
            habitats.delete(aHabitat)
            println("Habitat Deleted...")
            habitatView.listHabitats(habitats)
        } else
            println("Habitat not deleted...")
    }
        /*   fun dummyData() {
                habitats.create(HabitatModel(1, "Garden", "1.2", "2.3"))
                habitats.create(HabitatModel(2, "Field", "3.4", "4.5"))
                habitats.create(HabitatModel(3, "Hedgerow", "6.7", "7.8"))
            }*/

        fun exit() {
            println("Exiting Habitat Menu")
        }

    }



