package com.mateuszholik.network.models

import com.google.gson.annotations.SerializedName

data class TeamApi(
    @SerializedName("crest")
    val crest: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null,
    @SerializedName("tla")
    val tla: String? = null,
)
