```kotlin
GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transition(GenericTransitionOptions.withNoTransition())
    .into(imageView)
```