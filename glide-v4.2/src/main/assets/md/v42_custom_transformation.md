```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transform(BlurTransformation(10))
    .into(imageView)
```