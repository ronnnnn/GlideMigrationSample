```kotlin
val target = object : SimpleTarget<Bitmap>() {
    override fun onLoadStarted(placeholder: Drawable?) {
        imageView.setImageDrawable(placeholder)
    }

    override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
        Palette.from(resource).generate { palette ->
            val color = palette?.getVibrantColor(ContextCompat.getColor(context, R.color.color_primary))
                ?: ContextCompat.getColor(context, R.color.color_primary)
        imageView.setImageBitmap(resource)
        imageView.setColorFilter(color)
        }
    }
}

GlideApp.with(context)
    .asBitmap()
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .into(target)
```