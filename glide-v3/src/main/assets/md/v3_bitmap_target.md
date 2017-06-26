```kotlin
val target = object : SimpleTarget<Bitmap>() {
    override fun onLoadStarted(placeholder: Drawable?) {
        imageView.setImageDrawable(placeholder)
    }

    override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
        Palette.from(resource).generate { palette ->
            val color = palette?.getVibrantColor(ContextCompat.getColor(context, R.color.color_primary))
                ?: ContextCompat.getColor(context, R.color.color_primary)
            imageView.setImageBitmap(resource)
            imageView.setColorFilter(color)
        }
    }
}

Glide.with(context)
    .load(imageString)
    .asBitmap()
    .placeholder(R.drawable.image_placeholder)
    .into(target)
```