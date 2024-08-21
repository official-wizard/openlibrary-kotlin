package org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class CreateList {

    data class Request(

        @SerializedName("name")
        val name: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("tags")
        val tags: List<String>? = null,

        @SerializedName("seeds")
        val seeds: List<String>? = null
    )

    data class Response(

        @SerializedName("key")
        val key: String,

        @SerializedName("revision")
        val revision: Int
    )
}