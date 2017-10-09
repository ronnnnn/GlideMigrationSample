```kotlin
val animationObject = ViewPropertyTransition.Animator { view ->
    view.alpha = 0f

    ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply { 
        duration = 300
    }.start()
}

GlideApp.with(context)
    .load(imageString)
    .placeholder(R.drawable.image_placeholder)
    .transition(DrawableTransitionOptions().transition(animationObject)) // this animation affect not only ImageView but also whole View
    .into(imageView)
```