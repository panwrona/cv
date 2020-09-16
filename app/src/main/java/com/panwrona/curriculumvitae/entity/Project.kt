package com.panwrona.curriculumvitae.entity

import com.panwrona.curriculumvitae.data.response.ProjectResponse

data class Project(
    val name: String,
    val description: String,
    val technologies: List<String>,
    val url: String?
) {
    companion object {
        fun from(response: ProjectResponse) = Project(
            name = response.name,
            description = response.description,
            technologies = response.technologies,
            url = response.url
        )
    }
}