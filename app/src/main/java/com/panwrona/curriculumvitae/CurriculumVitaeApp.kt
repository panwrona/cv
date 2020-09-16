package com.panwrona.curriculumvitae

import android.app.Application
import com.panwrona.curriculumvitae.cache.Cache
import com.panwrona.curriculumvitae.cache.PreferencesCache
import com.panwrona.curriculumvitae.common.StringProvider
import com.panwrona.curriculumvitae.data.ApiClient
import com.panwrona.curriculumvitae.data.RestClient
import com.panwrona.curriculumvitae.repository.Repository
import com.panwrona.curriculumvitae.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CurriculumVitaeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CurriculumVitaeApp)
            modules(module {
                single<Cache> { PreferencesCache(get()) }
                single<RestClient> { ApiClient() }
                single { StringProvider(get()) }
                single { Repository(get(), get(), get()) }

                viewModel { MainViewModel(get()) }
            })
        }
    }
}