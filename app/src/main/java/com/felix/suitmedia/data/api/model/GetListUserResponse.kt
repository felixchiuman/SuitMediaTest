package com.felix.suitmedia.model


import com.google.gson.annotations.SerializedName

data class GetListUserResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("data")
    val `data`: List<userData>,
    @SerializedName("support")
    val support: Support
)

    data class userData(
        @SerializedName("id")
        val id: Int,
        @SerializedName("email")
        val email: String,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("avatar")
        val avatar: String
    )

    data class Support(
        @SerializedName("url")
        val url: String,
        @SerializedName("text")
        val text: String
    )