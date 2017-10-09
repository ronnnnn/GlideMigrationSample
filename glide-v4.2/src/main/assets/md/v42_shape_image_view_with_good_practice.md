```kotlin
GlideApp.with(this)
    .load(photoList[0].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions().transition(android.R.anim.fade_in))
    .into(circleImageView)

GlideApp.with(this)
    .load(photoList[1].getPhotoUrl())
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions().transition((android.R.anim.fade_in)))
    .into(diamondImageView)
```