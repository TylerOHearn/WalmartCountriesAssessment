package com.example.walmartcountriesassessment.data.result

import data.model.CountryDetails

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data:T): Result<T>()
    data class Error(val message: String, val throwable: Throwable? = null): Result<Nothing>()
}