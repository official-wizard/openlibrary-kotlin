package org.openlibrary.org.openlibrary.api.data.pojo.cover

import com.google.gson.annotations.SerializedName

class SearchCover {

    data class Response(

        @SerializedName("id")
        val id: String,

        @SerializedName("category_id")
        val categoryId: Long,

        @SerializedName("olid")
        val olid: String,

        @SerializedName("filename")
        val filename: String,

        @SerializedName("author")
        val author: String,

        @SerializedName("ip")
        val ip: String,

        @SerializedName("source_url")
        val sourceUrl: String,

        @SerializedName("source")
        val source: String?,

        @SerializedName("isbn")
        val isbn: String?,

        @SerializedName("created")
        val created: String,

        @SerializedName("last_modified")
        val lastModified: String,

        @SerializedName("archived")
        val archived: Boolean,

        @SerializedName("failed")
        val failed: Boolean,

        @SerializedName("width")
        val width: Int,

        @SerializedName("height")
        val height: Int,

        @SerializedName("filename_s")
        val filenameSmall: String,

        @SerializedName("filename_m")
        val filenameMedium: String,

        @SerializedName("filename_l")
        val filenameLarge: String,

        @SerializedName("isbn13")
        val isbn13: String?,

        @SerializedName("uploaded")
        val uploaded: Boolean,

        @SerializedName("deleted")
        val deleted: Boolean,

        @SerializedName("filename_old")
        val filenameOld: String?
    )
}