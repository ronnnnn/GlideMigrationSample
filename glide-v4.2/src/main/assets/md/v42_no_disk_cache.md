```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .diskCacheStrategy(DiskCacheStrategy.NONE) // default is RESULT
    .into(imageView)
```