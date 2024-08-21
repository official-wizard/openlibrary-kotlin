package org.openlibrary.api.data.pojo.changes

import com.google.gson.annotations.SerializedName

class SearchChanges {

    data class Response(

        @SerializedName("id")
        val id: String,

        @SerializedName("kind")
        val kind: String,

        @SerializedName("timestamp")
        val timestamp: String,

        @SerializedName("comment")
        val comment: String,

        @SerializedName("changes")
        val changes: List<Change>,

        @SerializedName("author")
        val author: Author,

        @SerializedName("ip")
        val ip: String?,

        @SerializedName("data")
        val data: Data
    ) {

        data class Change(

            @SerializedName("key")
            val key: String,

            @SerializedName("revision")
            val revision: Int
        )

        data class Author(

            @SerializedName("key")
            val key: String
        )

        data class Data(

            @SerializedName("master")
            val master: String,

            @SerializedName("duplicates")
            val duplicates: List<String>
        )
    }
}