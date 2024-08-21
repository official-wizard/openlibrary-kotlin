package org.openlibrary.api.data.pojo.works

import com.google.gson.annotations.SerializedName

class SearchWorks {

    data class Response(

        @SerializedName("title")
        val title: String,

        @SerializedName("key")
        val key: String,

        @SerializedName("authors")
        val authors: List<AuthorEntry>,

        @SerializedName("description")
        val description: String,

        @SerializedName("covers")
        val covers: List<Long>,

        @SerializedName("subject_places")
        val subjectPlaces: List<String>,

        @SerializedName("subjects")
        val subjects: List<String>,

        @SerializedName("subject_people")
        val subjectPeople: List<String>,

        @SerializedName("subject_times")
        val subjectTimes: List<String>,

        @SerializedName("location")
        val location: String,

        @SerializedName("latest_revision")
        val latestRevision: Int,

        @SerializedName("revision")
        val revision: Int,

        @SerializedName("created")
        val created: Created,

        @SerializedName("last_modified")
        val modified: Modified
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
    }
}