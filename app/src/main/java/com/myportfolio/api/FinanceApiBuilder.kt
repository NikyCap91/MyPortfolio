package com.myportfolio.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object FinanceApiBuilder {

    private const val BASE_API_URL = "https://trader.degiro.nl"

    fun create(): FinanceApi {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        return Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
                .build()
                .create(FinanceApi::class.java)
    }
}