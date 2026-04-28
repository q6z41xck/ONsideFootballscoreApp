package com.mateuszholik.network.models

import com.google.gson.annotations.SerializedName

data class CompetitionApi(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("emblem")
    val emblem: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null
)
