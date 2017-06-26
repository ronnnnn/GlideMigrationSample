```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .crossFade(1000) // default duration is 300
    .into(imageView)
```