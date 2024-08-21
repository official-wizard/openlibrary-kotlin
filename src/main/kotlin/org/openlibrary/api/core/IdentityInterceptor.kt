package org.openlibrary.api.core

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.openlibrary.org.openlibrary.api.Identifier

/**
 * This [Interceptor] takes care of identifying our client to OpenLibrary for moderation purposes
 */
class IdentityInterceptor(private val identifier: Identifier): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("User-Agent", identifier.clientID)

        return chain.proceed(request.build())
    }
}
