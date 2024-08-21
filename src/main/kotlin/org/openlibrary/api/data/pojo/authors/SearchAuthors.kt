package org.openlibrary.org.openlibrary.api.data.pojo.authors

import com.google.gson.annotations.SerializedName

class SearchAuthors {

    data class Response(

        @SerializedName("numFound")
        val numFound: Int,

        @SerializedName("start")
        val start: Int,

        @SerializedName("numFoundExact")
        val numFoundExact: Boolean,

        @SerializedName("docs")
        val documents: List<Document>

    ) {
        data class Document(

            @SerializedName("key")
            val key: String,

            @SerializedName("text")
            val text: List<String>,

            @SerializedName("type")
            val type: String,

            @SerializedName("name")
            val name: String,

            @SerializedName("alternate_names")
            val alternateNames: List<String>,

            @SerializedName("birth_date")
            val birthDate: String,

            @SerializedName("top_work")
            val topWork : String,

            @SerializedName("work_count")
            val workCount: Int,

            @SerializedName("top_subjects")
            val topSubjects: List<String>,

            @SerializedName("_version_")
            val version: String
        )
    }
}