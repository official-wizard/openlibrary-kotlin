package org.openlibrary.api.data.pojo.subjects

import com.google.gson.annotations.SerializedName

class SearchSubjects {

    data class Response(

        @SerializedName("key")
        val key: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("subject_type")
        val subjectType: String,

        @SerializedName("work_count")
        val workCount: Int,

        @SerializedName("ebook_count")
        val ebookCount: Int,

        @SerializedName("works")
        val works: List<Work>,

        @SerializedName("authors")
        val authors: List<Author>
    ) {

        data class Author(

            @SerializedName("count")
            val count: Int,

            @SerializedName("name")
            val name: String,

            @SerializedName("key")
            val key: String
        )

        data class Publisher(

            @SerializedName("count")
            val count: Int,

            @SerializedName("name")
            val name: String
        )

        data class Subject(

            @SerializedName("count")
            val count: Int,

            @SerializedName("name")
            val name: String,

            @SerializedName("key")
            val key: String
        )

        data class People(

            @SerializedName("count")
            val count: Int,

            @SerializedName("name")
            val name: String,

            @SerializedName("key")
            val key: String
        )

        data class Places(

            @SerializedName("count")
            val count: Int,

            @SerializedName("name")
            val name: String,

            @SerializedName("key")
            val key: String
        )

        data class Times(

            @SerializedName("count")
            val count: Int,

            @SerializedName("name")
            val name: String,

            @SerializedName("key")
            val key: String
        )

        data class Work(

            @SerializedName("key")
            val key: String,

            @SerializedName("title")
            val title: String,

            @SerializedName("edition_count")
            val editionCount: Int,

            @SerializedName("authors")
            val authors: List<Author>,

            @SerializedName("has_full_text")
            val hasFullText: Boolean,

            @SerializedName("ia")
            val ia: String
        ) {
            data class Author(

                @SerializedName("name")
                val name: String,

                @SerializedName("key")
                val key: String
            )
        }


    }
}