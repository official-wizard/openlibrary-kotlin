package org.openlibrary.api.core

import okhttp3.ResponseBody
import org.openlibrary.api.data.pojo.account.Login
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class LoginConverterFactory(val client: CoreClient): Converter.Factory() {

    override fun responseBodyConverter(
        type: Type, annotations: Array<Annotation>, retrofit: Retrofit,
    ): Converter<ResponseBody, *>? {

        if (type === Login.Response::class.java) {
            return LoginConverter(client)
        }

        return null
    }
}