package workshop.mirceasoit.fivedaysweather.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import workshop.mirceasoit.fivedaysweather.R

@BindingAdapter("image","placeholder")
fun setIcon(image: ImageView, url: String?, placeHolder: Drawable) {
    if (!url.isNullOrEmpty()){
        Glide.with(image.context).load(url).centerCrop()
            .placeholder(R.drawable.ic_not_available)
            .into(image)
    }
    else{
        image.setImageDrawable(placeHolder)
    }
}