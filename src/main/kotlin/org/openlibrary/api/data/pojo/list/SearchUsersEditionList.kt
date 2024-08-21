package org.openlibrary.org.openlibrary.api.data.pojo.list

import com.google.gson.annotations.SerializedName

class SearchUsersEditionList {

    data class Response(

        @SerializedName("links")
        val links: Links,

        @SerializedName("size")
        val size: Int,

        @SerializedName("entries")
        val entries: List<Entry>
    ) {

        data class Entry(

            @SerializedName("number_of_pages")
            val numberOfPages: Int,

            @SerializedName("table_of_contents")
            val tableOfContents: List<*>,

            @SerializedName("series")
            val series: List<String>,

            @SerializedName("covers")
            val covers: List<Int>,

            @SerializedName("lc_classifications")
            val lcClassifications: List<String>,

            @SerializedName("latest_revision")
            val latestRevision: Int,

            @SerializedName("ocaid")
            val ocaid: String,

            @SerializedName("subtitle:")
            val subtitle: String,

            @SerializedName("source_records")
            val sourceRecords: List<String>,

            @SerializedName("title")
            val title: String,

            @SerializedName("languages")
            val languages: List<Langauge>,

            @SerializedName("publish_country")
            val publishCountry: String,

            @SerializedName("by_statement")
            val byStatement: String,

            @SerializedName("oclc_numbers")
            val oclcNumbers: List<String>,

            @SerializedName("type")
            val type: Type,

            @SerializedName("revision")
            val revision: Int,

            @SerializedName("publishers")
            val publishers: List<String>,

            @SerializedName("last_modified")
            val lastModified: Modified,

            @SerializedName("key")
            val key: String,

            @SerializedName("authors")
            val authors: List<Author>,

            @SerializedName("publish_places")
            val publishPlaces: List<String>,

            @SerializedName("pagination")
            val pagination: String,

            @SerializedName("classification")
            val classification: Classification,

            @SerializedName("created")
            val created: Created,

            @SerializedName("lccn")
            val lccn: List<String>,

            @SerializedName("identifiers")
            val identifiers: Identifiers,

            @SerializedName("publish_date")
            val publishDate: String,

            @SerializedName("works")
            val works: List<Work>
        ) {

            data class Work(

                @SerializedName("key")
                val key: String
            )

            class Identifiers

            data class Created(

                @SerializedName("type")
                val type: String,

                @SerializedName("value")
                val value: String
            )

            class Classification

            data class Author(

                @SerializedName("key")
                val key: String
            )

            data class Modified(

                @SerializedName("type")
                val type: String,

                @SerializedName("value")
                val value: String
            )

            data class Type(

                @SerializedName("key")
                val key: String
            )

            data class Langauge(

                @SerializedName("key")
                val key: String
            )
        }

        data class Links(

            @SerializedName("self")
            val self: String,

            @SerializedName("next")
            val next: String,

            @SerializedName("list")
            val list: String
        )
    }
}