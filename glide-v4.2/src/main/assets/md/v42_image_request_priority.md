```kotlin
Glide.with(this)
    .load(photoList[0].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .priority(Priority.HIGH)
    .into(firstImageView)

Glide.with(this)
    .load(photoList[1].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .priority(Priority.LOW)
    .into(secondImageView)
```