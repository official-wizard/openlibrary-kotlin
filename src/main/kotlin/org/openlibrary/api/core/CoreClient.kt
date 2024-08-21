package org.openlibrary.api.core

import com.google.gson.*
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.openlibrary.api.core.gson.DescriptionDeserializer
import org.openlibrary.org.openlibrary.api.Identifier
import org.openlibrary.org.openlibrary.api.data.pojo.authors.SearchAuthorsWorks
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

open class CoreClient(baseUrl: String, identifier: Identifier, debugging: Boolean = false) {

    // custom [OkHttpClient] client to add an authentication interceptor
    var httpClient: OkHttpClient = OkHttpClient.Builder().apply {
        if (debugging) {
            addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })

            addInterceptor(IdentityInterceptor(identifier))
        }
    }.build()

    // custom [Retrofit] client to add custom [OkHttpClient] and add Gson (JSON) support
    val openClient: Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().apply {

            // descriptions for this can be a string or an object, to catch both we created a custom deserializer
            registerTypeAdapter(SearchAuthorsWorks.Response.Entry.Description::class.java, DescriptionDeserializer())

        }.create()))
        .baseUrl(baseUrl)
        .client(httpClient)
        .build()
}
