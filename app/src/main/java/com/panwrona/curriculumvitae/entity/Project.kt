package com.panwrona.curriculumvitae.entity

data class Project(
    val name: String,
    val description: String,
    val technologies: List<Technology>,
    val url: String?
)