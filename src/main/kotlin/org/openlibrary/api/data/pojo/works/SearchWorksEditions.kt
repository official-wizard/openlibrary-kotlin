package org.openlibrary.api.data.pojo.works

import com.google.gson.annotations.SerializedName

class SearchWorksEditions {

    data class Response(

        @SerializedName("links")
        val links: Links,

        @SerializedName("size")
        val size: Long,

        @SerializedName("entries")
        val entries: List<Entry>
    ) {

        data class Entry(

            @SerializedName("type")
            val type: Type,

            @SerializedName("authors")
            val authors: List<Author>,

            @SerializedName("isbn_13")
            val isbn13: List<String>,

            @SerializedName("languages")
            val languages: List<Language>,

            @SerializedName("pagination")
            val pagination: String,

            @SerializedName("publish_date")
            val publishDate: String,

            @SerializedName("publishers")
            val publishers: List<String>,

            @SerializedName("source_records")
            val sourceRecords: List<String>,

            @SerializedName("subjects")
            val subjects: List<String>,

            @SerializedName("title")
            val title: String,

            @SerializedName("weight")
            val weight: String?,

            @SerializedName("full_title")
            val fullTitle: String,

            @SerializedName("works")
            val works: List<Work>,

            @SerializedName("key")
            val key: String,

            @SerializedName("covers")
            val covers: List<Long>,

            @SerializedName("number_of_pages")
            val numberOfPages: Int,

            @SerializedName("latest_revision")
            val latestRevision: Int,

            @SerializedName("revision")
            val revision: Int,

            @SerializedName("created")
            val created: Created,

            @SerializedName("last_modified")
            val lastModified: Modified
        ) {

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

            data class Work(

                @SerializedName("key")
                val key: String
            )

            data class Language(

                @SerializedName("key")
                val key: String
            )

            data class Type(

                @SerializedName("key")
                val key: String
            )

            data class Author(

                @SerializedName("key")
                val key: String
            )
        }

        data class Links(

            @SerializedName("self")
            val self: String,

            @SerializedName("work")
            val work: String,

            @SerializedName("next")
            val next: String
        )
    }
}