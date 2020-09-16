package com.panwrona.curriculumvitae.data.response

import com.google.gson.annotations.SerializedName

data class SkillResponse(
    @SerializedName("name") val name: String,
    @SerializedName("level") val level: Int
)