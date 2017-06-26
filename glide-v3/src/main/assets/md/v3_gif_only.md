```kotlin
Glide.with(context)
    .load(imageString)
    .asGif()
    .placeholder(R.drawable.image_placeholder)
    .error(R.drawable.image_error) // this error will be called the source is not gif
    .into(imageView)
```