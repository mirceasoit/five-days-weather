package workshop.mirceasoit.fivedaysweather.model

import com.squareup.moshi.Json

data class Data(@field:Json(name = "cod") val cod: String,
                @field:Json(name = "message") val message: String,
                @field:Json(name = "list") val list: List<WeatherInfo>)
