```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(imageView)
```