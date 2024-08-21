package org.openlibrary.api.data.pojo

import com.google.gson.annotations.SerializedName

class ErrorResponse {

    data class Response(

        @SerializedName("error")
        val error: String,

        @SerializedName("key")
        val key: String
    )
}