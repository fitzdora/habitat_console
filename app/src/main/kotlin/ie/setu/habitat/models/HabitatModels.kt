package ie.setu.habitat.models

data class HabitatModel(
    var id: Long = 0,
    var habitatType : String = "",
    var latitudeString : String = "",
    var longitudeString : String = ""
)