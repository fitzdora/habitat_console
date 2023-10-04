package ie.setu.habitat.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class HabitatMemStore : HabitatStore {

    val habitats = ArrayList<HabitatModel>()

    override fun findAll(): List<HabitatModel> {
           return habitats
    }

    override fun findOne(id: Long): HabitatModel? {
        var foundHabitat: HabitatModel? = habitats.find { h -> h.id == id }
        return foundHabitat
    }
    override fun create(habitat: HabitatModel) {
        habitat.id = getId()
        habitats.add(habitat)
        logAll()
    }

    override fun update(habitat: HabitatModel) {
        var foundHabitat = findOne(habitat.id!!)

        if(foundHabitat != null) {
            foundHabitat.habitatType = habitat.habitatType
            foundHabitat.latitudeString = habitat.latitudeString
            foundHabitat.longitudeString = habitat.longitudeString
        }
    }

    internal fun logAll() {
        habitats.forEach{ logger.info("${it}")}
    }
}