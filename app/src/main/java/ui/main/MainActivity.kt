package com.example.walmartcountriesassessment.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartcountriesassessment.databinding.ActivityMainBinding
import com.example.walmartcountriesassessment.ui.adapters.CountriesAdapater
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import com.example.walmartcountriesassessment.data.result.Result

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CountriesViewModel by viewModels()
    private val adapter = CountriesAdapater()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        binding.recycler.isNestedScrollingEnabled = false // important for nested scroll container

        // Refresh button
        binding.refreshButton.setOnClickListener {
            Timber.Forest.d("Refresh button clicked")
            viewModel.refresh()
        }

        // Observe data
        viewModel.countries.observe(this) { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progress.visibility = View.VISIBLE
                }

                is Result.Success -> {
                    binding.progress.visibility = View.GONE
                    adapter.updateItems(result.data)
                }

                is Result.Error -> {
                    binding.progress.visibility = View.GONE
                    Snackbar.make(binding.root, result.message, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}