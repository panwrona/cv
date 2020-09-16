package com.panwrona.curriculumvitae.data.response

import com.google.gson.annotations.SerializedName

data class JobResponse(
    @SerializedName("company_name") val companyName: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val endDate: String?,
    @SerializedName("position") val position: String,
    @SerializedName("projects") val projects: List<ProjectResponse>
)