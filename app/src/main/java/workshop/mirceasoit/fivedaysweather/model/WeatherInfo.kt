package workshop.mirceasoit.fivedaysweather.model

import com.squareup.moshi.Json

data class WeatherInfo(@field:Json(name = "dt") val dt: String,
                       @field:Json(name = "dt_txt")val dtTxt: String,
                       @field:Json(name = "weather")val weather: List<Weather>)
