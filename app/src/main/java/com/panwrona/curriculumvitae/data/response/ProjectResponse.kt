package com.panwrona.curriculumvitae.data.response

import com.google.gson.annotations.SerializedName

data class ProjectResponse(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("technologies") val technologies: List<String>,
    @SerializedName("url") val url: String?
)