```kotlin
GlideApp.with(this)
    .load(R.drawable.ic_android_black_36dp)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(imageView)
```