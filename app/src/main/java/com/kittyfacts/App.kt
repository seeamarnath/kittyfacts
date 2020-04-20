package com.kittyfacts

import android.app.Application
import com.kittyfacts.repository.APIService
import com.kittyfacts.repository.WebService
import com.kittyfacts.viewmodels.KittyFactsListViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
        listOf(mainModule),
            loadPropertiesFromFile = true)
    }
}

val mainModule = module {
    single { WebService(get()) }
    single { createWebService() }
    viewModel { KittyFactsListViewModel(get()) }
}

fun createWebService(): APIService {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://cat-fact.herokuapp.com")
        .build()

    return retrofit.create(APIService::class.java)
}
