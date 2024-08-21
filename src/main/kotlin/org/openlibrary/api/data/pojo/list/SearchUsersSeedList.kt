package org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class SearchUsersSeedList {

    data class Response(

        @SerializedName("size")
        val size: Int,

        @SerializedName("links")
        val links: Links,

        val entries: List<Entry>
    ) {

        data class Entry(

            @SerializedName("url")
            val url: String,

            @SerializedName("full_url")
            val fullURL: String,

            @SerializedName("type")
            val type: String,

            @SerializedName("title")
            val title: String,

            @SerializedName("last_update")
            val lastUpdate: String,

            @SerializedName("work_count")
            val workCount: Int,

            @SerializedName("edition_count")
            val editionCount: Int,

            @SerializedName("ebook_count")
            val ebookCount: Int,

            @SerializedName("picture")
            val picture: Picture
        ) {
            data class Picture(

                @SerializedName("url")
                val url: String
            )
        }

        data class Links(

            @SerializedName("self")
            val self: String,

            @SerializedName("list")
            val list: String
        )
    }
}