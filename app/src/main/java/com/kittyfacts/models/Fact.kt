package com.kittyfacts.models

import com.google.gson.annotations.SerializedName

data class Fact (
    @SerializedName("_id") var id: String,
    @SerializedName("text") var text: String
)