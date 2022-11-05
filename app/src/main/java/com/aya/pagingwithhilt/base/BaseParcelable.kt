package com.aya.pagingwithhilt.base

import android.os.Parcelable

interface BaseParcelable : Parcelable {
    fun unique(): Any
}