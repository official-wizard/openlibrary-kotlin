package org.openlibrary.org.openlibrary.api

import com.haroldadmin.cnradapter.NetworkResponse
import okhttp3.ResponseBody
import org.openlibrary.org.openlibrary.api.data.CoverSize
import org.openlibrary.org.openlibrary.api.data.Partner
import org.openlibrary.org.openlibrary.api.data.pojo.cover.SearchCover
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenLibraryCoverInterface {

    @GET("/b/{partner}/{partnerId}-{size}.jpg")
    suspend fun searchCoverPicture(
        @Path("partner") partner: Partner,
        @Path("partnerId") partnerId: String,
        @Path("size") size: CoverSize = CoverSize.S
    ): NetworkResponse<ResponseBody, Unit>

    @GET("/a/{partner}/{partnerId}-{size}.jpg")
    suspend fun searchAuthorPicture(
        @Path("partner") partner: Partner,
        @Path("partnerId") partnerId: String,
        @Path("size") size: CoverSize = CoverSize.S
    ): NetworkResponse<ResponseBody, Unit>

    @GET("/b/id/{id}.json")
    suspend fun searchCoverDetails(
        @Path("id") id: String,
    ): NetworkResponse<SearchCover.Response, SearchCover.Response>

}