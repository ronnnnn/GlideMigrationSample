```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .circleCrop()
    .into(imageView)
```