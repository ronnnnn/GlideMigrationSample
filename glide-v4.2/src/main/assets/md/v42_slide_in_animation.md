```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions().transition(android.R.anim.slide_in_left))
    .into(imageView)
```