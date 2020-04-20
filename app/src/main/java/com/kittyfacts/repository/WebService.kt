package com.kittyfacts.repository

import com.kittyfacts.models.FactResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebService(private val api: APIService) {

    fun getFacts(callback: ResponseCallback) {

        api.getFacts().enqueue(object : Callback<FactResponse> {

            override fun onResponse(call: Call<FactResponse>, response: Response<FactResponse>) {
                if (response.isSuccessful)
                    callback.onSuccess((response.body() as FactResponse))
                else
                    callback.onFailure(response.code())
            }

            override fun onFailure(call: Call<FactResponse>, t: Throwable) {
                callback.onFailure(0)
            }
        })
    }

    interface ResponseCallback {
        fun onSuccess(data: FactResponse)
        fun onFailure(code: Int)
    }

}