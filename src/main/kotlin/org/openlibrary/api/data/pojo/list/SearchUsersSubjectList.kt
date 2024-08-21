package org.openlibrary.org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class SearchUsersSubjectList {

    data class Response(

        @SerializedName("links")
        val links: Links,

        @SerializedName("subjects")
        val subjects: List<Subject>,

        @SerializedName("places")
        val places: List<Places>,

        @SerializedName("people")
        val people: List<People>,

        @SerializedName("times")
        val times: List<People>
    ) {

        data class Times(

            @SerializedName("count")
            val count: Int,

            @SerializedName("url")
            val url: String,

            @SerializedName("name")
            val name: String
        )

        data class People(

            @SerializedName("count")
            val count: Int,

            @SerializedName("url")
            val url: String,

            @SerializedName("name")
            val name: String
        )

        data class Places(

            @SerializedName("count")
            val count: Int,

            @SerializedName("url")
            val url: String,

            @SerializedName("name")
            val name: String
        )

        data class Subject(

            @SerializedName("count")
            val count: Int,

            @SerializedName("url")
            val url: String,

            @SerializedName("name")
            val name: String
        )

        data class Links(

            @SerializedName("self")
            val self: String,

            @SerializedName("list")
            val list: String
        )
    }
}