```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .animate(R.anim.zoom_in)
    .into(imageView)
```