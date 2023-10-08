package ie.setu.habitat.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import ie.setu.habitat.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "habitats.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<HabitatModel>>() {}.type

fun generateRandomId(): Long {
    return  Random().nextLong()
}
class HabitatJSONStore : HabitatStore {

    var habitats = mutableListOf<HabitatModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<HabitatModel> {
        return habitats
    }

    override fun findOne(id: Long): HabitatModel? {
       var foundHabitat: HabitatModel? = habitats.find { h -> h.id == id }
        return foundHabitat
    }

    override fun create(habitat: HabitatModel) {
        habitat.id = generateRandomId()
        habitats.add(habitat)
        serialize()
    }

    override fun update(habitat: HabitatModel) {
        var foundHabitat = findOne(habitat.id!!)
        if (foundHabitat != null ){
            foundHabitat.habitatType = habitat.habitatType
            foundHabitat.latitudeString = habitat.latitudeString
            foundHabitat.longitudeString = habitat.longitudeString
        }
        serialize()
    }

    override fun delete(habitat: HabitatModel) {
        habitats.remove(habitat)
        serialize()
    }

    internal fun logAll() {
        habitats.forEach { logger.info("${it}")}
    }

    private fun serialize() {
        val  jsonString = gsonBuilder.toJson(habitats, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize(){
        val jsonString = read(JSON_FILE)
        habitats = Gson().fromJson(jsonString, listType)
    }

}