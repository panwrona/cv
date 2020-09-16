package com.panwrona.curriculumvitae.cache

import android.content.Context
import com.google.gson.Gson
import com.panwrona.curriculumvitae.data.response.CurriculumVitaeResponse

class PreferencesCache(
    context: Context,
    private val gson: Gson = Gson()
): Cache {
    private val PREFERENCES_TAG = "CurriculumVitaeSharedPreferences"
    private val CURRICULUM_VITAE = "curriculumVitae"

    private val prefs = context.getSharedPreferences(PREFERENCES_TAG, Context.MODE_PRIVATE)

    override fun getCurriculumVitae(): CurriculumVitaeResponse? {
        val json = prefs.getString(CURRICULUM_VITAE, null)
        return gson.fromJson(json, CurriculumVitaeResponse::class.java)
    }

    override fun saveCurriculumVitae(cv: CurriculumVitaeResponse) {
        val json = gson.toJson(cv)
        prefs.edit().putString(json, null).apply()
    }
}