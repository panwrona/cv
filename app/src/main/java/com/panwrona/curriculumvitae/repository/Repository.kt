package com.panwrona.curriculumvitae.repository

import com.panwrona.curriculumvitae.R
import com.panwrona.curriculumvitae.cache.Cache
import com.panwrona.curriculumvitae.common.StringProvider
import com.panwrona.curriculumvitae.data.RestClient
import com.panwrona.curriculumvitae.entity.CurriculumVitae
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class Repository(
    private val cache: Cache,
    private val restClient: RestClient,
    private val stringProvider: StringProvider,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getCurriculumVitae(): Payload<CurriculumVitae> = coroutineCall(stringProvider, dispatcher) {
        val cvFromCache = cache.getCurriculumVitae()
        if(cvFromCache != null) {
            CurriculumVitae.from(cvFromCache)
        } else {
            val response = restClient.getCurriculumVitae()
            cache.saveCurriculumVitae(response)
            CurriculumVitae.from(response)
        }
    }
}

suspend fun <T> coroutineCall(
    stringProvider: StringProvider,
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): Payload<T> {
    return withContext(dispatcher) {
        try {
            Payload.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Payload.NetworkError(stringProvider.getString(R.string.error_network_error))
                is HttpException -> {
                    val code = throwable.code()
                    Payload.ServerError(code, stringProvider.getString(R.string.error_http_error))
                }
                else -> {
                    Payload.GeneralError(stringProvider.getString(R.string.error_general))
                }
            }
        }
    }
}