package com.aya.pagingwithhilt.features.fragments.photos.data

import com.aya.pagingwithhilt.core.pagination.INITIAL_PAGE_INDEX
import com.aya.pagingwithhilt.core.pagination.PagingParams
import com.google.gson.annotations.SerializedName

data class PhotosParams(
    @SerializedName("type")
    var type: Int,
) : PagingParams() {
    override fun dataClass(): Any = this
    override var page: Int = INITIAL_PAGE_INDEX
}
