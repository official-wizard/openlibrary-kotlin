package org.openlibrary.api.data.pojo.authors

import com.google.gson.annotations.SerializedName

class SearchAuthorsWorks {

    data class Response(

        @SerializedName("links")
        val links: Links,

        @SerializedName("size")
        val size: Int,

        @SerializedName("entries")
        val entries: List<Entry>
    ) {

        data class Entry(

            @SerializedName("type")
            val type: Type,

            @SerializedName("title")
            val title: String,

            @SerializedName("authors")
            val authors: List<AuthorEntry>,

            @SerializedName("key")
            val key: String,

            @SerializedName("latest_revision")
            val latestRevision: Int,

            @SerializedName("revision")
            val revision: Int,

            @SerializedName("subjects")
            val subjects: List<String>,

            @SerializedName("created")
            val created: Created,

            @SerializedName("last_modified")
            val lastModified: Modified,

            @SerializedName("description")
            val description: Description?,

            @SerializedName("links")
            val links: List<Links>,

            @SerializedName("covers")
            val covers: List<Long>,

            @SerializedName("subject_places")
            val subjectPlaces: List<String>,

            @SerializedName("subject_people")
            val subjectPeople: List<String>,

            @SerializedName("excerpts")
            val excerpts: List<Excerpt>,

            @SerializedName("first_publish_date")
            val firstPublishDate: String
        ) {

            data class Excerpt(

                @SerializedName("author")
                val author: Author,

                @SerializedName("comment")
                val comment: String?,

                @SerializedName("excerpt")
                val excerpt: String?
            ) {

                data class Author(

                    @SerializedName("key")
                    val key: String
                )
            }

            data class Links(

                @SerializedName("url")
                val url: String,

                @SerializedName("title")
                val title: String,

                @SerializedName("type")
                val type: Type
            ) {

                data class Type (

                    @SerializedName("key")
                    val key: String
                )
            }

            data class Description(

                @SerializedName("type")
                val type: String,

                @SerializedName("value")
                val value: String
            )

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


            data class AuthorEntry(

                @SerializedName("author")
                val author: Author,

                @SerializedName("type")
                val type: Type
            ) {

                data class Author(

                    @SerializedName("key")
                    val key: String
                )

                data class Type(

                    @SerializedName("key")
                    val key: String
                )
            }

            data class Type(

                @SerializedName("key")
                val key: String
            )
        }

        data class Links(

            @SerializedName("self")
            val self: String,

            @SerializedName("author")
            val author: String,

            @SerializedName("next")
            val next: String
        )
    }
}