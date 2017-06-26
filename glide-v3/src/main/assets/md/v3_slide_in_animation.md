```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .animate(android.R.anim.slide_in_left)
    .into(imageView)
```