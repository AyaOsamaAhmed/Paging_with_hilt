package com.aya.pagingwithhilt.features.fragments.photos.ui

import com.aya.pagingwithhilt.base.Action
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotoItem

sealed class PhotosAction : Action {
    object OnBackButton : PhotosAction()
    data class PhotosList(val photosList: List<PhotoItem>) : PhotosAction()
    data class PhotoItemClicked(val item: PhotoItem) : PhotosAction()
    data class ShowLoading(val show: Boolean) : PhotosAction()
    data class ShowMessage(val message: String) : PhotosAction()
}
