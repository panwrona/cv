package com.panwrona.curriculumvitae.data.response

import com.google.gson.annotations.SerializedName

data class CurriculumVitaeResponse(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("about_me") val aboutMe: String,
    @SerializedName("current_position") val currentPosition: String,
    @SerializedName("email") val email: String,
    @SerializedName("schools") val schools: List<SchoolResponse>,
    @SerializedName("jobs") val jobs: List<JobResponse>,
    @SerializedName("skills") val skills: List<SkillResponse>,
    @SerializedName("languages") val languages: List<LanguageResponse>,
    @SerializedName("hobbies") val hobbies: List<String>
)