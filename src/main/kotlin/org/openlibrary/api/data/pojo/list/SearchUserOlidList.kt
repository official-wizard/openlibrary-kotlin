package org.openlibrary.org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class SearchUserOlidList {

    data class Response(

        @SerializedName("links")
        val links: Links,

        @SerializedName("meta")
        val meta: Meta,

        @SerializedName("name")
        val name: String,

        @SerializedName("description")
        val description: String?,

        @SerializedName("seed_count")
        val seedCount: Int,

        @SerializedName("edition_count")
        val editionCount: Int
    ) {

        data class Meta(

            @SerializedName("last_modified")
            val lastModified: String,

            @SerializedName("revision")
            val revision: Int,

            @SerializedName("created")
            val created: String
        )

        data class Links(

            @SerializedName("editions")
            val editions: String,

            @SerializedName("self")
            val self: String,

            @SerializedName("seeds")
            val seeds: String,

            @SerializedName("subjects")
            val subjects: String
        )
    }
}