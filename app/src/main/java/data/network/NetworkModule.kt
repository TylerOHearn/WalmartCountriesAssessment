package data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import data.api.CountriesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import kotlin.getValue

object NetworkModule {
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private const val BASE = "https://gist.githubusercontent.com/"

    private val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }
        .apply { level = HttpLoggingInterceptor.Level.BASIC }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    val api: CountriesApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CountriesApi::class.java)
    }
}