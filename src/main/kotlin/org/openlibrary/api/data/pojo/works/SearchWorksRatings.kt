package org.openlibrary.api.data.pojo.works

import com.google.gson.annotations.SerializedName

class SearchWorksRatings {

    data class Response(

        @SerializedName("summary")
        val summary: Summary,

        @SerializedName("counts")
        val counts: Counts
    ) {

        data class Counts(

            @SerializedName("1")
            val one: Long,

            @SerializedName("2")
            val two: Long,

            @SerializedName("3")
            val three: Long,

            @SerializedName("4")
            val four: Long,

            @SerializedName("5")
            val five: Long
        )

        data class Summary(

            @SerializedName("average")
            val average: Double,

            @SerializedName("count")
            val count: Long,

            @SerializedName("sortable")
            val sortable: Double
        )
    }
}