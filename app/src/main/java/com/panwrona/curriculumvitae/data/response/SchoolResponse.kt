package com.panwrona.curriculumvitae.data.response

import com.google.gson.annotations.SerializedName

data class SchoolResponse(
    @SerializedName("name") val name: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("field_of_study") val fieldOfStudy: String
)