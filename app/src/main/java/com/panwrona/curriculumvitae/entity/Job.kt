package com.panwrona.curriculumvitae.entity

data class Job(
    val name: String,
    val startDate: String,
    val endDate: String,
    val position: String,
    val projects: List<Project>
)