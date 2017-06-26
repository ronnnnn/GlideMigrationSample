```kotlin
Glide.with(context)
    .load(imageString)
    .asBitmap() // gif will show as a regular image even if the url ends with .gif
    .placeholder(R.drawable.image_placeholder)
    .into(imageView)
```