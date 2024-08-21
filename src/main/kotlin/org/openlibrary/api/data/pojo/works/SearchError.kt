package org.openlibrary.org.openlibrary.api.data.pojo.works

import com.google.gson.annotations.SerializedName

class SearchError {

    data class Response(

        @SerializedName("error")
        val error: String,

        @SerializedName("key")
        val key: String
    )
}