package hr.ferit.brunozoric.taskie.di

import android.os.Build
import hr.ferit.brunozoric.taskie.BuildConfig
import hr.ferit.brunozoric.taskie.common.AUTH_INTERCEPTOR
import hr.ferit.brunozoric.taskie.common.BASE_URL
import hr.ferit.brunozoric.taskie.common.KEY_AUTHORIZATION
import hr.ferit.brunozoric.taskie.common.LOGGING_INTERCEPTOR
import hr.ferit.brunozoric.taskie.networking.TaskieApiService
import hr.ferit.brunozoric.taskie.prefs.SharedPrefsHelper
import hr.ferit.brunozoric.taskie.prefs.provideSharedPrefs
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val prefs = provideSharedPrefs()

val networkingModule = module {
    //Gson
    single { GsonConverterFactory.create() as Converter.Factory }

    //Interceptor
    single ( named(LOGGING_INTERCEPTOR)){
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single (named(AUTH_INTERCEPTOR)){
        Interceptor{
            val request = it.request().newBuilder()
                .addHeader(KEY_AUTHORIZATION, prefs.getUserToken())
                .build()
            it.proceed(request)
        }
    }

    //OkHttpClient
    single {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG){
                addInterceptor(get(named(LOGGING_INTERCEPTOR)))
                addInterceptor(get(named(AUTH_INTERCEPTOR)))
            }
            readTimeout(1L, TimeUnit.MINUTES)
            connectTimeout(1L, TimeUnit.MINUTES)
        }.build()
    }

    //Retrofit
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(TaskieApiService::class.java) }
}