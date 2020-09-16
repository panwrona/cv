package com.panwrona.curriculumvitae.entity

import com.panwrona.curriculumvitae.data.response.LanguageResponse

data class Language(
    val name: String,
    val level: String
) {
    companion object {
        fun from(response: LanguageResponse) = Language(response.name, response.level)
    }
}