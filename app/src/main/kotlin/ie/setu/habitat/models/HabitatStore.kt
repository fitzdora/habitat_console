package ie.setu.habitat.models

interface HabitatStore {
    fun findAll(): List<HabitatModel>
    fun findOne(id: Long): HabitatModel?
    fun create (habitat: HabitatModel)
    fun update(habitat: HabitatModel)
}