package com.panwrona.curriculumvitae.data

import com.panwrona.curriculumvitae.data.response.CurriculumVitaeResponse

interface RestClient {
    suspend fun getCurriculumVitae(): CurriculumVitaeResponse
}