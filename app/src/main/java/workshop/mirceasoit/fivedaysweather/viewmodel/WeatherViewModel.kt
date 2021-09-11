package workshop.mirceasoit.fivedaysweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import workshop.mirceasoit.fivedaysweather.api.State
import workshop.mirceasoit.fivedaysweather.repository.WeatherRepository

class WeatherViewModel (private val meteorsRepository: WeatherRepository) : ViewModel() {

    private var _data = MutableLiveData<State>()
    var data: LiveData<State> = _data

    fun getData() {
        _data.value = State.Loading
        viewModelScope.launch {
            _data.value = meteorsRepository.getData()
        }
    }

}