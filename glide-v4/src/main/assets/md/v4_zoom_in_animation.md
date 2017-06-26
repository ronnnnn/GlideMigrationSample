```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions().transition(R.anim.zoom_in))
    .into(imageView)
```