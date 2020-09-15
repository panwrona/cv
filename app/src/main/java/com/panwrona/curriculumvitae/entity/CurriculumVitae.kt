package com.panwrona.curriculumvitae.entity

data class CurriculumVitae(
    val name: String,
    val surname: String,
    val aboutMe: String,
    val currentPosition: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val schools: List<School>,
    val jobs: List<Job>,
    val skills: List<Skill>,
    val languages: List<Language>,
    val hobbies: List<String>
)