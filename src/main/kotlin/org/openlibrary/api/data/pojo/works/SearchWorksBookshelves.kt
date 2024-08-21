package org.openlibrary.api.data.pojo.works

import com.google.gson.annotations.SerializedName

class SearchWorksBookshelves {

    data class Response(

        @SerializedName("counts")
        val counts: Counts

    ) {
        data class Counts(

            @SerializedName("want_to_read")
            val wantToRead: Long,

            @SerializedName("currently_reading")
            val currentlyReading: Long,

            @SerializedName("already_read")
            val alreadyRead: Long
        )
    }
}