package org.openlibrary.api.core

import okhttp3.ResponseBody
import org.openlibrary.api.data.pojo.account.Login
import retrofit2.Converter
import java.net.URI
import java.net.URLDecoder

/**
 * This [LoginConverter] class takes care of returning our [Login.Response] based on
 * if the [client]'s CookieManager successfully has the session cookie stored.
 */
class LoginConverter(val client: CoreClient): Converter<ResponseBody, Login.Response> {

    override fun convert(p0: ResponseBody): Login.Response {
        val session = client.cookieManager.cookieStore.get(URI.create(client.baseUrl))
            .firstOrNull { it.name.equals("session") }

        if (session == null) {
            return Login.Response(false)
        }

        if (session.value.isNullOrEmpty()) {
            return Login.Response(false)
        }

        val peopleData = URLDecoder.decode(session.value, "UTF-8").split(",")[0]
        val username = peopleData.split("/")[2]

        return Login.Response(true, session.value, username)
    }

}