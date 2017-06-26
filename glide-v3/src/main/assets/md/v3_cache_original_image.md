```kotlin
Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
    .into(imageView)
```