package com.panwrona.curriculumvitae.entity

import com.panwrona.curriculumvitae.data.response.JobResponse

data class Job(
    val companyName: String,
    val startDate: String,
    val endDate: String?,
    val position: String,
    val projects: List<Project>
) {
    companion object {
        fun from(response: JobResponse) = Job(
            companyName = response.companyName,
            startDate = response.startDate,
            endDate = response.endDate,
            position = response.position,
            projects = response.projects.map {
                Project.from(it)
            }
        )
    }
}