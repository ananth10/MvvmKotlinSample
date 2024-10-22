package com.ananth.mvvmkotlinsample.di


import com.ananth.mvvmkotlinsample.BuildConfig
import com.ananth.mvvmkotlinsample.data.remote.api.GithubApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @networkModules here we are declared network dependency
 *
 * */

val networkModules= module {

    single {
        HttpLoggingInterceptor().apply {
            level=HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get<HttpLoggingInterceptor>())
            addInterceptor{ chain ->
                val request:Request=chain.request().newBuilder().build()
                chain.proceed(request)

            }
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
            .build()
    }

    single {
        get<Retrofit>().create(GithubApiService::class.java)
    }
}
