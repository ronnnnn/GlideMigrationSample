```kotlin
GlideApp.with(this)
    .load(photoList[0].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(circleImageView)

GlideApp.with(this)
    .load(photoList[1].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(diamondImageView)
```