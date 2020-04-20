package com.kittyfacts.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kittyfacts.models.FactResponse
import com.kittyfacts.repository.WebService
import org.koin.standalone.KoinComponent

class KittyFactsListViewModel(private val webService: WebService) : ViewModel(), KoinComponent {

    var factsList = MutableLiveData<FactResponse>()

    fun getFacts() {
        webService.getFacts(object : WebService.ResponseCallback {
            override fun onSuccess(data: FactResponse) {
                factsList.value = data
            }
            override fun onFailure(code: Int) {
            }
        })
    }
}