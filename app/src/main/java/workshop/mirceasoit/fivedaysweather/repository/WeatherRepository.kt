package workshop.mirceasoit.fivedaysweather.repository

import workshop.mirceasoit.fivedaysweather.api.State
import workshop.mirceasoit.fivedaysweather.api.WeatherApi

class WeatherRepository {

    suspend fun getData(): State {
        return try {
            val response = WeatherApi.retrofitService.getData()
            State.Success(response.list)
        } catch (throwable: Throwable) {
            State.Error(throwable.message)
        }
    }
}