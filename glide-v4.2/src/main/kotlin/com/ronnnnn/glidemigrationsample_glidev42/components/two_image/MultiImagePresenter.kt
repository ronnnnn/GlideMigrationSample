package com.ronnnnn.glidemigrationsample_glidev42.components.two_image

import com.ronnnnn.glidemigrationsample_glidev42.models.Photo
import com.ronnnnn.glidemigrationsample_glidev42.use_case.LoadImageUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/06/19.
 */
class MultiImagePresenter(private val multiImageView: MultiImageView) {

    val useCase = LoadImageUseCase()

    fun loadRecentPhotos() {
        useCase.getRecentPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { multiImageView.setLoadingProgressVisibility(true) }
                .doOnSuccess { multiImageView.setLoadingProgressVisibility(false) }
                .doOnError { multiImageView.setLoadingProgressVisibility(false) }
                .subscribe({ photoList ->
                    multiImageView.setImages(photoList)
                }, { throwable ->
                    Timber.e(throwable)
                })
    }

    interface MultiImageView {

        fun setLoadingProgressVisibility(isVisible: Boolean)

        fun setImages(photoList: List<Photo>)
    }
}