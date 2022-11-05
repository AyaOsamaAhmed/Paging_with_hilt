package com.aya.pagingwithhilt.features.fragments.photos.domain

import com.aya.pagingwithhilt.core.network.MainRepository
import com.aya.pagingwithhilt.core.pagination.BasePagingDataSource
import com.aya.pagingwithhilt.core.pagination.BasePagingResponse
import com.aya.pagingwithhilt.core.pagination.PagingParams
import com.aya.pagingwithhilt.core.response.ErrorResponse
import com.aya.pagingwithhilt.core.response.NetworkResponse
import com.aya.pagingwithhilt.core.usecase.BaseResponse
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotosParams
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotosResponseItem

class PhotosSource(
    private val homeRepo: MainRepository,
    private val params: PhotosParams
) : BasePagingDataSource<PhotosResponseItem>() {

    override val queryParams: PagingParams = params
    override suspend fun execute(): NetworkResponse<BaseResponse<BasePagingResponse<PhotosResponseItem>>, ErrorResponse> {
        return homeRepo.getPhotos(params)
    }
}