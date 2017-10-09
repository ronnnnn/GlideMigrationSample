```kotlin
GlideApp.with(context)
    .asBitmap() // gif will show as a regular image even if the url ends with .gif
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .into(imageView)
```