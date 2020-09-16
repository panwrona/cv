package com.panwrona.curriculumvitae.entity

import com.panwrona.curriculumvitae.data.response.SchoolResponse

data class School(
    val name: String,
    val startDate: String,
    val endDate: String,
    val title: String,
    val fieldOfStudy: String
) {
    companion object {
        fun from(response: SchoolResponse) = School(
            name = response.name,
            startDate = response.startDate,
            endDate = response.endDate,
            title = response.title,
            fieldOfStudy = response.fieldOfStudy
        )
    }
}