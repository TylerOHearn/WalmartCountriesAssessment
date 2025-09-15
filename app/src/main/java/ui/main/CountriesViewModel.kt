package com.example.walmartcountriesassessment.ui.main

import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walmartcountriesassessment.data.repository.CountriesRepository
import com.example.walmartcountriesassessment.data.result.Result
import kotlinx.coroutines.launch
import data.model.CountryDetails
import timber.log.Timber

class CountriesViewModel(private val countriesRepository: CountriesRepository = CountriesRepository()) : ViewModel() {

    private val _countries = MutableLiveData<Result<List<CountryDetails>>>()
    val countries: LiveData<Result<List<CountryDetails>>> = _countries

    init {
        refresh()
    }

    fun refresh() {
        Timber.d("ViewModel:Refreshing countries")
        _countries.value = Result.Loading
        viewModelScope.launch {
            val res = countriesRepository.fetchCountries()
            _countries.value = res
        }
    }
}