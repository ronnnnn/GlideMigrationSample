```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .bitmapTransform(GrayscaleTransformation(context), BlurTransformation(context, 10))
    .into(imageView)
```