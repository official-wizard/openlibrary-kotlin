package org.openlibrary.org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class SearchUsersList {

    data class Response(

        @SerializedName("links")
        val links: Links,

        @SerializedName("size")
        val size: Int,

        @SerializedName("entries")
        val entries: List<Entry>
    ) {

        data class Entry(

            @SerializedName("url")
            val url: String,

            @SerializedName("full_url")
            val fullURL: String,

            @SerializedName("name")
            val name: String,

            @SerializedName("last_update")
            val lastUpdate: String,

            @SerializedName("seed_count")
            val seedCount: Long,

            @SerializedName("edition_count")
            val editionCount: Long
        )

        data class Links(

            @SerializedName("self")
            val self: String,

            @SerializedName("next")
            val next: String
        )
    }
}