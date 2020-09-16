package com.panwrona.curriculumvitae.cache

import com.panwrona.curriculumvitae.data.response.CurriculumVitaeResponse

interface Cache {
    fun getCurriculumVitae(): CurriculumVitaeResponse?
    fun saveCurriculumVitae(cv: CurriculumVitaeResponse)
}