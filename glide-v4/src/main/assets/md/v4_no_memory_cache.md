```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .skipMemoryCache(true) // default is false
    .into(imageView)
```