```kotlin
val target = object : SimpleTarget<Bitmap>(200, 200) {
    override fun onLoadStarted(placeholder: Drawable?) {
        imageView.setImageDrawable(placeholder)
    }

    override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
        imageView.setImageBitmap(resource)
    }
}

GlideApp.with(context)
    .asBitmap()
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .into(target)
```