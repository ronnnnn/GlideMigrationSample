```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .centerCrop()
    .into(imageView)
```