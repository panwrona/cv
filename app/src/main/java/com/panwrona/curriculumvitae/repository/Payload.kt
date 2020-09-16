package com.panwrona.curriculumvitae.repository

sealed class Payload<out T> {
    data class Success<out T>(val value: T): Payload<T>()
    data class GeneralError(val error: String): Payload<Nothing>()
    data class ServerError(val code: Int, val error: String): Payload<Nothing>()
    data class NetworkError(val error: String): Payload<Nothing>()
}