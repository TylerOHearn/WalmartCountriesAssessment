package data.model

import com.squareup.moshi.Json

data class CountryDetails(
    @Json(name = "name") val name: String?,
    @Json(name = "region") val region: String?,
    @Json(name = "code") val code: String?,
    @Json(name = "capital") val capital: String?
)