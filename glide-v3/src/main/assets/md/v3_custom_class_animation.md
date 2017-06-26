```kotlin
val animationObject = ViewPropertyAnimation.Animator { view ->
    view.alpha = 0f

    ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply { 
        duration = 3000
    }.start()
}

Glide.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .animate(animationObject) // this animation affect not only ImageView but also whole View
    .into(imageView)
```