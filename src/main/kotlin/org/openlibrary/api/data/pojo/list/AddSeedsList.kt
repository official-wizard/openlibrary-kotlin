package org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class AddSeedsList {

    data class Request(

        @SerializedName("add")
        val add: List<Seed>

    ) {

        data class Seed(

            @SerializedName("key")
            val key: String
        )
    }

    data class Response(

        @SerializedName("key")
        val key: String,

        @SerializedName("revision")
        val revision: Int
    )
}