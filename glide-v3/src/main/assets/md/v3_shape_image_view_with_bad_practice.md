```kotlin
Glide.with(this)
    .load(photoList[0].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .into(circleImageView)

Glide.with(this)
    .load(photoList[1].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .into(diamondImageView)
```