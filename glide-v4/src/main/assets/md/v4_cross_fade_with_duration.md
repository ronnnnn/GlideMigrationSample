```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions.withCrossFade(1000)) // default duration is 300
    .into(imageView)
```