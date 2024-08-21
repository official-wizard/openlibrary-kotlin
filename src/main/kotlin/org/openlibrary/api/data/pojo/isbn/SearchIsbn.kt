package org.openlibrary.org.openlibrary.api.data.pojo.isbn

import com.google.gson.annotations.SerializedName

class SearchIsbn {

    data class Response(

        @SerializedName("identifiers")
        val identifiers: Identifiers,

        @SerializedName("title")
        val title: String,

        @SerializedName("authors")
        val authors: List<Author>,

        @SerializedName("publish_date")
        val publishDate: String,

        @SerializedName("publishers")
        val publishers: List<String>,

        @SerializedName("covers")
        val covers: List<Long>,

        @SerializedName("contributions")
        val contributions: List<String>,

        @SerializedName("languages")
        val languages: List<Language>,

        @SerializedName("source_records")
        val sourceRecords: List<String>,

        @SerializedName("local_id")
        val localId: List<String>,

        @SerializedName("type")
        val type: Type,

        @SerializedName("first_sentence")
        val firstSentence: FirstSentence,

        @SerializedName("key")
        val key: String,

        @SerializedName("number_of_pages")
        val numberOfPages: Int,

        @SerializedName("works")
        val works: List<Work>,

        @SerializedName("classifications")
        val classifications: Classification,

        @SerializedName("ocaid")
        val ocaid: String,

        @SerializedName("isbn_10")
        val isbn10: List<String>,

        @SerializedName("isbn_13")
        val isbn13: List<String>,

        @SerializedName("latest_revision")
        val latestRevision: Int,

        @SerializedName("revision")
        val revision: Int,

        @SerializedName("created")
        val created: Created,

        @SerializedName("last_modified")
        val lastModified: Modified
    ) {

        class Classification

        data class Modified(

            @SerializedName("type")
            val type: String,

            @SerializedName("value")
            val value: String
        )

        data class Created(

            @SerializedName("type")
            val type: String,

            @SerializedName("value")
            val value: String
        )

        data class FirstSentence(

            @SerializedName("type")
            val type: String,

            @SerializedName("value")
            val value: String
        )

        data class Work(

            @SerializedName("key")
            val key: String
        )

        data class Type(

            @SerializedName("key")
            val key: String
        )

        data class Language(

            @SerializedName("key")
            val key: String
        )

        data class Author(

            @SerializedName("key")
            val key: String
        )

        data class Identifiers(

            @SerializedName("goodreads")
            val goodReads: List<String>,

            @SerializedName("librarything")
            val libraryThing: List<String>
        )
    }
}