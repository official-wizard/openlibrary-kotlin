package org.openlibrary.api.data.pojo.book

import com.google.gson.annotations.SerializedName

class SearchBooks {

    data class Response(

        @SerializedName("start")
        val start: Long,

        @SerializedName("num_found")
        val numFound: Long,

        @SerializedName("docs")
        val documents: List<Document>,

        @SerializedName("offset")
        val offset: Long?,

        @SerializedName("q")
        val query: String,

        @SerializedName("namFoundExact")
        val nameFoundExact: Boolean
    ) {

        data class Document(

            @SerializedName("cover_i")
            val coverI: Long?,

            @SerializedName("has_fulltext")
            val hasFullText: Boolean,

            @SerializedName("edition_count")
            val editionCount: Long,

            @SerializedName("title")
            val title: String,

            @SerializedName("author_name")
            val authorNames: List<String>,

            @SerializedName("first_publish_year")
            val firstPublishYear: Int,

            @SerializedName("key")
            val key: String,

            @SerializedName("ia")
            val ia: List<String>,

            @SerializedName("author_key")
            val authorKeys: List<String>,

            @SerializedName("public_scan_b")
            val publicScanB: Boolean
        )
    }
}