```kotlin
val target = object : SimpleTarget<Bitmap>(200, 200) {
    override fun onLoadStarted(placeholder: Drawable?) {
        imageView.setImageDrawable(placeholder)
    }

    override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
        imageView.setImageBitmap(resource)
    }
}

Glide.with(context)
    .load(imageString)
    .asBitmap()
    .placeholder(R.drawable.image_placeholder)
    .into(target)
```