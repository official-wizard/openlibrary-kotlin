package org.openlibrary.api.data.pojo.my

import com.google.gson.annotations.SerializedName

class SearchMyBooks {

    data class Response(

        @SerializedName("page")
        val page: Long,

        @SerializedName("numFound")
        val numFound: Long,

        @SerializedName("reading_log_entries")
        val readingLogEntries: List<Entry>
    ) {

        data class Entry(

            @SerializedName("work")
            val work: Work,

            @SerializedName("logged_edition")
            val loggedEdition: String,

            @SerializedName("logged_date")
            val loggedDate: String
        ) {

            data class Work(

                @SerializedName("title")
                val title: String,

                @SerializedName("key")
                val key: String,

                @SerializedName("author_keys")
                val authorKeys: List<String>,

                @SerializedName("author_names")
                val authorNames: List<String>,

                @SerializedName("first_publish_year")
                val firstPublishYear: Int,

                @SerializedName("lending_edition_s")
                val lendingEditionS: String?,

                @SerializedName("edition_key")
                val editionKeys: List<String>,

                @SerializedName("cover_id")
                val coverId: Long?,

                @SerializedName("cover_edition_key")
                val coverEditionKey: String?
            )
        }
    }
}