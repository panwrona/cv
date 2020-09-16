package com.panwrona.curriculumvitae.entity

import com.panwrona.curriculumvitae.data.response.CurriculumVitaeResponse

data class CurriculumVitae(
    val name: String,
    val surname: String,
    val aboutMe: String,
    val currentPosition: String,
    val email: String,
    val schools: List<School>,
    val jobs: List<Job>,
    val skills: List<Skill>,
    val languages: List<Language>,
    val hobbies: List<String>
) {
    companion object {
        fun from(response: CurriculumVitaeResponse) = CurriculumVitae(
                name = response.name,
                surname = response.surname,
                aboutMe = response.aboutMe,
                currentPosition = response.currentPosition,
                email = response.email,
                schools = response.schools.map {
                    School.from(it)
                },
                jobs = response.jobs.map {
                    Job.from(it)
                },
                skills = response.skills.map {
                    Skill.from(it)
                },
                languages = response.languages.map {
                    Language.from(it)
                },
                hobbies = response.hobbies
            )
    }
}