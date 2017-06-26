```kotlin
Glide.with(this)
    .load(photoList[0].getPhotoUrl())
    .asBitmap()
    .placeholder(R.drawable.image_placeholder)
    .animate(android.R.anim.fade_in)
    .into(circleImageView)

Glide.with(this)
    .load(photoList[1].getPhotoUrl())
    .asBitmap()
    .placeholder(R.drawable.image_placeholder)
    .animate(android.R.anim.fade_in)
    .into(diamondImageView)
```