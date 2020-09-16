package com.panwrona.curriculumvitae.data

import com.panwrona.curriculumvitae.data.response.CurriculumVitaeResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getCurriculumVitae(
        @Url url: String
    ): CurriculumVitaeResponse
}