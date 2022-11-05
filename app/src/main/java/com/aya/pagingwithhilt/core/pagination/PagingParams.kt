package com.aya.pagingwithhilt.core.pagination

import com.aya.pagingwithhilt.core.extension.HashMapParams


abstract class PagingParams : HashMapParams {
    abstract var page: Int
}