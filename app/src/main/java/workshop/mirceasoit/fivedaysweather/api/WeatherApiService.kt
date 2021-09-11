package workshop.mirceasoit.fivedaysweather.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import workshop.mirceasoit.fivedaysweather.model.Data

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
private const val OPEN_WEATHER_API_KEY = "your_api_here"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface WeatherApiService {
    @GET("forecast?q=Oslo&appid=$OPEN_WEATHER_API_KEY")
    suspend fun getData(): Data
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy { retrofit.create(
        WeatherApiService::class.java) }
}