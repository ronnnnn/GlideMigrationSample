```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transform(MultiTransformation(GrayscaleTransformation(), BlurTransformation(10)))
    .into(imageView)
```