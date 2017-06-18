package com.ronnnnn.glidemigrationsample.components.image_list

import com.ronnnnn.glidemigrationsample.models.Photo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/06/18.
 */
class ImageListPresenter(private val imageListView: ImageListView) {

    private val useCase = ImageListUseCase()

    fun getRecentPhotos() {
        useCase.getRecentPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ photos ->
                    imageListView.setPhotos(photos)
                }, { throwable ->
                    Timber.e(throwable)
                })
    }

    interface ImageListView {
        fun setPhotos(photoList: List<Photo>)
    }
}