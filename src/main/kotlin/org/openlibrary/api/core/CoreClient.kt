package org.openlibrary.api.core

import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.openlibrary.api.core.gson.DescriptionDeserializer
import org.openlibrary.api.Identifier
import org.openlibrary.api.data.pojo.authors.SearchAuthorsWorks
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy


open class CoreClient(val baseUrl: String, identifier: Identifier, debugging: Boolean = false) {

    // cookie manager for authentication handling
    // when the authenticate() function is used, the Web API stores the "session" key as a cookie
    // which means we must store this for later use & requests
    var cookieManager = CookieManager().apply {
        setCookiePolicy(CookiePolicy.ACCEPT_ALL)
    }

    // custom [OkHttpClient] client to add an authentication interceptor
    var httpClient: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(IdentityInterceptor(identifier))
        cookieJar(JavaNetCookieJar(cookieManager))

        if (debugging) {
            addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
        }
    }.build()

    // custom [Retrofit] client to add custom [OkHttpClient] and add Gson (JSON) support
    val openClient: Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(LoginConverterFactory(this@CoreClient))
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().apply {

            // descriptions for this can be a string or an object, to catch both we created a custom deserializer
            registerTypeAdapter(SearchAuthorsWorks.Response.Entry.Description::class.java, DescriptionDeserializer())

        }.create()))
        .baseUrl(baseUrl)
        .client(httpClient)
        .build()
}
