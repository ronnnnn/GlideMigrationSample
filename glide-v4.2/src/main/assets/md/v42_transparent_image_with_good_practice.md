```kotlin
GlideApp.with(this)
    .load(R.drawable.ic_android_black_36dp)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions().crossFade(
        DrawableCrossFadeFactory.Builder()
            .setCrossFadeEnabled(true)
            .build()
    ))
    // or
    // .transition(DrawableTransitionOptions().transition(android.R.anim.fade_in))
    .into(imageView)
```