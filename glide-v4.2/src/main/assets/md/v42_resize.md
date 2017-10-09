```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .override(200, 200) // resize image (in pixel) not ImageView before displaying in the target
    .into(imageView)
```