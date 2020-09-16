package com.panwrona.curriculumvitae.entity

import com.panwrona.curriculumvitae.data.response.SkillResponse

data class Skill(
    val name: String,
    val level: Int
) {
    companion object {
        fun from(response: SkillResponse) = Skill(
            name = response.name,
            level = response.level
        )
    }
}

