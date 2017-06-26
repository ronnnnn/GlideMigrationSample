```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .error(R.drawable.image_error)
    .into(imageView)
```