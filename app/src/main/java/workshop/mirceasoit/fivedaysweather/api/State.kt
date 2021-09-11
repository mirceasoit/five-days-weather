package workshop.mirceasoit.fivedaysweather.api

import workshop.mirceasoit.fivedaysweather.model.WeatherInfo

sealed class State {
    object Loading : State()
    data class Success(val data: List<WeatherInfo>) : State()
    data class Error(val error: String?) : State()

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error
}