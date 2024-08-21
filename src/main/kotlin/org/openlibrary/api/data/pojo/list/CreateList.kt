package org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class CreateList {

    data class Request(

        @SerializedName("name")
        val name: String,

        @SerializedName("description")
        val description: String
    )

    data class Response(

        @SerializedName("key")
        val key: String,

        @SerializedName("revision")
        val revision: Int
    )
}