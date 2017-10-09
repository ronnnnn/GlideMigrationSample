```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transforms(GrayscaleTransformation(), BlurTransformation(10))
    .into(imageView)
```