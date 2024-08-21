package org.openlibrary.api.data.pojo.partner

import com.google.gson.annotations.SerializedName

class SearchPartner {

    data class Response(

        @SerializedName("items")
        val items: List<Item>,

        @SerializedName("records")
        val records: Map<String, Record>

    ) {
        data class Record(

            @SerializedName("isbns")
            val isbns: List<String>,

            @SerializedName("lccns")
            val lccns: List<String>,

            @SerializedName("oclcs")
            val oclcs: List<String>,

            @SerializedName("olids")
            val olids: List<String>,

            @SerializedName("publishDates")
            val publishDates: List<String>,

            @SerializedName("recordURL")
            val recordURL: String,

            //TODO: add data from Data API
        )

        data class Item(
            @SerializedName("match")
            val match: Match,

            @SerializedName("status")
            val status: String,

            @SerializedName("itemURL")
            val itemURL: String,

            @SerializedName("cover")
            val cover: Cover,

            @SerializedName("fromRecord")
            val fromRecord: String,

            @SerializedName("publishDate")
            val publishDate: String,

            @SerializedName("ol-edition-id")
            val olEditionId: String,

            @SerializedName("ol-work-id")
            val olWorkId: String
        ) {

            data class Cover(

                @SerializedName("small")
                val small: String?,

                @SerializedName("medium")
                val medium: String?,

                @SerializedName("large")
                val large: String?
            )

            enum class Match {
                exact, similar
            }
        }
    }
}