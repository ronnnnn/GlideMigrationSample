package com.ronnnnn.glidemigrationsample.components.shape_image

import com.ronnnnn.glidemigrationsample.models.Photo
import com.ronnnnn.glidemigrationsample.use_case.LoadImageUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/06/20.
 */
class ShapeImagePresenter(private val shapeImageView: ShapeImageView) {

    private val useCase = LoadImageUseCase()

    fun loadRecentPhotos() {
        useCase.getRecentPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { shapeImageView.toggleLoadingProgressVisibility(true) }
                .doOnSuccess { shapeImageView.toggleLoadingProgressVisibility(false) }
                .doOnError { shapeImageView.toggleLoadingProgressVisibility(false) }
                .subscribe({ photos ->
                    shapeImageView.setImages(photos)
                }, { throwable ->
                    Timber.e(throwable)
                })
    }

    interface ShapeImageView {
        fun toggleLoadingProgressVisibility(isVisible: Boolean)

        fun setImages(photoList: List<Photo>)
    }
}
