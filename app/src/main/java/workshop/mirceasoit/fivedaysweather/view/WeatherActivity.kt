package workshop.mirceasoit.fivedaysweather.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import workshop.mirceasoit.fivedaysweather.R
import workshop.mirceasoit.fivedaysweather.api.State
import workshop.mirceasoit.fivedaysweather.databinding.ActivityWeatherBinding
import workshop.mirceasoit.fivedaysweather.repository.WeatherRepository
import workshop.mirceasoit.fivedaysweather.viewmodel.WeatherViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter
    private val _viewModel: WeatherViewModel by viewModels {
        object :
            ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return WeatherViewModel(WeatherRepository()) as T
            }
        }
    }
    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = WeatherAdapter()
        _viewModel.data.observe(this, { result ->
            when (result) {
                is State.Loading -> {}
                is State.Success -> {
                    adapter.submitData(result.data)
                    adapter.notifyDataSetChanged()
                }
                is State.Error -> {
                    binding.error.text = result.error
                }
            }
        })
        binding = DataBindingUtil.setContentView<ActivityWeatherBinding>(this,
            R.layout.activity_weather
        ).apply {
            viewmodel = _viewModel
            lifecycleOwner = this@WeatherActivity
            content.layoutManager = GridLayoutManager(this@WeatherActivity, 1)
            content.adapter = adapter
        }
        loadData()
    }

    private fun loadData() {
        _viewModel.loadData()
    }
}