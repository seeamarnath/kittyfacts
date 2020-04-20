package com.kittyfacts.models

import com.google.gson.annotations.SerializedName

data class FactResponse (
    @SerializedName("all") var all: List<Fact>
)
