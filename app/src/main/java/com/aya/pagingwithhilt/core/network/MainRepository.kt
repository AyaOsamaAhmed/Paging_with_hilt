package com.aya.pagingwithhilt.core.network

import com.aya.pagingwithhilt.core.extension.toHashMapParams
import com.aya.pagingwithhilt.core.pagination.BasePagingResponse
import com.aya.pagingwithhilt.core.response.ErrorResponse
import com.aya.pagingwithhilt.core.response.NetworkResponse
import com.aya.pagingwithhilt.core.usecase.BaseResponse
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotosParams
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotosResponseItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPhotos(params : PhotosParams?):
            NetworkResponse<BaseResponse<BasePagingResponse<PhotosResponseItem>>, ErrorResponse> =
        apiService.getPhotos(params.toHashMapParams()!!)


}