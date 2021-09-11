package workshop.mirceasoit.fivedaysweather.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import workshop.mirceasoit.fivedaysweather.BR

class WeatherBindViewHolder<Data> internal constructor(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Data) {
        binding.setVariable(BR.data, item)
        binding.executePendingBindings()
    }
}