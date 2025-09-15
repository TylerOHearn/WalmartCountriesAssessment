package com.example.walmartcountriesassessment.data.repository

import data.api.CountriesApi
import data.model.CountryDetails
import data.network.NetworkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException
import com.example.walmartcountriesassessment.data.result.Result

class CountriesRepository(private val api: CountriesApi = NetworkModule.api) {
    suspend fun fetchCountries(): Result<List<CountryDetails>> {
        return withContext(Dispatchers.IO) {
            try {
                Timber.d("Fetching countries: making network call")
                val countryDetails = api.getCountryDetails()
                Timber.d("Fetched countries: returned ${countryDetails.size} items")
                Result.Success(countryDetails)
            } catch (t: Throwable) {
                Timber.e(t, "Failed to fetch countries")
                val msg = when (t) {
                    is IOException -> "Network error. Please check your internet connection and try again. If the problem persists, please contact support at 616-322-6564"
                    else -> "Unknown error occurred. See logs for details."
                }
                Result.Error(msg, t)
            }
        }
    }
}