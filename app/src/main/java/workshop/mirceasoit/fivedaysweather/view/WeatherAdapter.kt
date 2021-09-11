package workshop.mirceasoit.fivedaysweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import workshop.mirceasoit.fivedaysweather.R
import workshop.mirceasoit.fivedaysweather.model.Displayable
import workshop.mirceasoit.fivedaysweather.model.WeatherInfo

class WeatherAdapter() : ListAdapter<Displayable, WeatherBindViewHolder<Displayable>>(
        DIFF_CALLBACK
    ) {

    companion object {
        private const val WEATHER_INFO_ITEM =
            R.layout.weather_info_item
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Displayable>() {
            override fun areItemsTheSame(oldItem: Displayable, newItem: Displayable): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Displayable, newItem: Displayable): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherBindViewHolder<Displayable> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return WeatherBindViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].type
    }

    override fun onBindViewHolder(holder: WeatherBindViewHolder<Displayable>, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }

    fun submitData(weather: List<WeatherInfo>) {
        val entries: MutableList<Displayable> = mutableListOf()
        weather.forEach { weatherInfo ->
            weatherInfo.weather[0].iconUrl = "https://openweathermap.org/img/wn/" + weatherInfo.weather[0].icon + "@2x.png"
            entries.add(
                Displayable(type = WEATHER_INFO_ITEM,
                    weatherInfo = weatherInfo)
            )
        }
        submitList(entries)
    }
}