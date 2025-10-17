package com.example.movies.data.response

//LocalizedName, AdministrativeArea.LocalizedName, Country.LocalizedName, Region.LocalizedName
data class CityResponseItem(
    val administrativeArea: AdministrativeArea,
    val country: Country,
    val dataSets: List<String>,
    val englishName: String,
    val geoPosition: GeoPosition,
    val isAlias: Boolean,
    val key: String,
    val localizedName: String,
    val parentCity: ParentCity,
    val primaryPostalCode: String,
    val rank: Int,
    val region: Region,
    val supplementalAdminAreas: List<SupplementalAdminArea>,
    val timeZone: TimeZone,
    val type: String,
    val version: Int
)

fun CityResponseItem.toDto(): List<String> {
    return listOf(
        localizedName,
        administrativeArea.LocalizedName,
        country.LocalizedName,
        region.LocalizedName
    )
}