package com.aya.pagingwithhilt.core.network

import com.aya.pagingwithhilt.core.pagination.BasePagingResponse
import com.aya.pagingwithhilt.core.response.ErrorResponse
import com.aya.pagingwithhilt.core.response.NetworkResponse
import com.aya.pagingwithhilt.core.usecase.BaseResponse
import com.aya.pagingwithhilt.features.fragments.photos.data.PhotosResponseItem
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    companion object {
        private const val PHOTOS = "photos"
    }

    @GET(PHOTOS)
    suspend fun getPhotos(@QueryMap param: HashMap<String, String?>): NetworkResponse<BaseResponse<BasePagingResponse<PhotosResponseItem>>, ErrorResponse>
}