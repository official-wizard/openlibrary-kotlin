package org.openlibrary.api

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.haroldadmin.cnradapter.NetworkResponse
import org.openlibrary.api.data.pojo.account.Login
import org.openlibrary.api.data.Partner
import org.openlibrary.api.data.SearchChangesQuery
import org.openlibrary.api.data.pojo.ErrorResponse
import org.openlibrary.api.data.pojo.authors.SearchAuthors
import org.openlibrary.api.data.pojo.authors.SearchAuthorsWorks
import org.openlibrary.api.data.pojo.book.SearchBooks
import org.openlibrary.api.data.pojo.changes.SearchChanges
import org.openlibrary.api.data.pojo.isbn.SearchIsbn
import org.openlibrary.api.data.pojo.list.*
import org.openlibrary.api.data.pojo.my.SearchMyBooks
import org.openlibrary.api.data.pojo.partner.SearchPartner
import org.openlibrary.api.data.pojo.subjects.SearchSubjects
import org.openlibrary.api.data.pojo.works.*
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenLibraryInterface {

    @Mock @MockResponse(body = "/v1/search/SearchBooksByQuery.json")
    @GET("/search.json")
    suspend fun searchBooksByQuery(
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("lang") lang: String? = null,
        @Query("offset") offset: Long? = null,
        @Query("page") page: Long? = null
    ): NetworkResponse<SearchBooks.Response, SearchBooks.Response>

    @Mock @MockResponse(body = "/v1/search/SearchBooksByTitle.json")
    @GET("/search.json")
    suspend fun searchBooksByTitle(
        @Query("title") title: String,
        @Query("sort") sort: String? = null,
        @Query("lang") lang: String? = null,
        @Query("offset") offset: Long? = null,
        @Query("page") page: Long? = null
    ): NetworkResponse<SearchBooks.Response, SearchBooks.Response>

    @Mock @MockResponse(body = "/v1/search/SearchBooksByAuthor.json")
    @GET("/search.json")
    suspend fun searchBooksByAuthor(
        @Query("author") author: String,
        @Query("sort") sort: String? = null,
        @Query("lang") lang: String? = null,
        @Query("offset") offset: Long? = null,
        @Query("page") page: Long? = null
    ): NetworkResponse<SearchBooks.Response, SearchBooks.Response>

    @Mock @MockResponse(body = "/v1/my/SearchMyWantToReadBooks.json")
    @GET("/people/{username}/books/want-to-read.json")
    suspend fun searchMyWantToReadBooks(
        @Path("username") username: String,
        @Query("sort") sort: String? = null,
        @Query("lang") lang: String? = null,
        @Query("offset") offset: Long? = null,
        @Query("page") page: Long? = null
    ): NetworkResponse<SearchMyBooks.Response, SearchMyBooks.Response>

    @Mock @MockResponse(body = "/v1/my/SearchMyCurrentlyReadingBooks.json")
    @GET("/people/{username}/books/currently-reading.json")
    suspend fun searchMyCurrentlyReadingBooks(
        @Path("username") username: String,
        @Query("sort") sort: String? = null,
        @Query("lang") lang: String? = null,
        @Query("offset") offset: Long? = null,
        @Query("page") page: Long? = null
    ): NetworkResponse<SearchMyBooks.Response, SearchMyBooks.Response>

    @Mock @MockResponse(body = "/v1/my/SearchMyAlreadyReadBooks.json")
    @GET("/people/{username}/books/already-read.json")
    suspend fun searchMyAlreadyReadBooks(
        @Path("username") username: String,
        @Query("sort") sort: String? = null,
        @Query("lang") lang: String? = null,
        @Query("offset") offset: Long? = null,
        @Query("page") page: Long? = null
    ): NetworkResponse<SearchMyBooks.Response, SearchMyBooks.Response>

    @Mock @MockResponse(body = "/v1/works/SearchWorks.json")
    @GET("/works/{workId}.json")
    suspend fun searchWorks(
        @Path("workId") workId: String,
    ): NetworkResponse<SearchWorks.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/works/SearchWorksEditions.json")
    @GET("/works/{olid}/editions.json")
    suspend fun searchWorksEditions(
        @Path("olid") olid: String,
        @Query("offset") offset: Long? = null
    ): NetworkResponse<SearchWorksEditions.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/works/SearchWorksBookshelves.json")
    @GET("/works/{olid}/bookshelves.json")
    suspend fun searchWorksBookshelves(
        @Path("olid") olid: String,
    ): NetworkResponse<SearchWorksBookshelves.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/works/SearchWorksRatings.json")
    @GET("/works/{olid}/ratings.json")
    suspend fun searchWorksRatings(
        @Path("olid") olid: String,
    ): NetworkResponse<SearchWorksRatings.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/works/SearchIsbn.json")
    @GET("/isbn/{isbn}.json")
    suspend fun searchWorksIsbn(
        @Path("isbn") isbn: String
    ): NetworkResponse<SearchIsbn.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/authors/SearchAuthors.json")
    @GET("/search/authors.json")
    suspend fun searchAuthors(
        @Query("q") query: String
    ): NetworkResponse<SearchAuthors.Response, SearchAuthors.Response>

    @Mock @MockResponse(body = "/v1/authors/SearchAuthorsWorks.json")
    @GET("/authors/{olid}/works.json")
    suspend fun searchAuthorsWorks(
        @Path("olid") olid: String,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<SearchAuthorsWorks.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/subjects/SearchSubjects.json")
    @GET("/subjects/{subject}.json")
    suspend fun searchSubjects(
        @Path("subject") subject: String,
        @Query("details") details: Boolean = false,
        @Query("published_in") publishedInRange: String? = null,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<SearchSubjects.Response, SearchSubjects.Response>

    @Mock @MockResponse(body = "/v1/partner/SearchPartner.json")
    @GET("/api/volumes/brief/{partner}/{partnerId}.json")
    suspend fun searchPartner(
        @Path("partner") partner: Partner,
        @Path("partnerId") partnerId: String
    ): NetworkResponse<SearchPartner.Response, SearchPartner.Response>

    @Mock @MockResponse(body = "/v1/partner/SearchPartners.json")
    @GET("/api/volumes/brief/json/{request-list}")
    suspend fun searchPartners(
        @Path("request-list") requestList: String
    ): NetworkResponse<Map<String, SearchPartner.Response>, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/changes/SearchRecentChanges.json")
    @GET("/recentchanges.json")
    suspend fun searchRecentChanges(
        @Query("bot") bot: Boolean? = null,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<List<SearchChanges.Response>, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/changes/SearchChanges.json")
    @GET("/recentchanges/{query}")
    suspend fun searchChanges(
        @Path("query") query: SearchChangesQuery,
        @Query("bot") bot: Boolean? = null,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<List<SearchChanges.Response>, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchUsersList.json")
    @GET("/people/{username}/lists.json")
    suspend fun searchUsersList(
        @Path("username") username: String,
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<SearchUsersList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchUsersOlidList.json")
    @GET("/people/{username}/lists/{olid}.json")
    suspend fun searchUsersList(
        @Path("username") username: String,
        @Path("olid") olid: String
    ): NetworkResponse<SearchUserOlidList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchUsersSeedList.json")
    @GET("/people/{username}/lists/{olid}/seeds.json")
    suspend fun searchUsersSeedList(
        @Path("username") username: String,
        @Path("olid") olid: String
    ): NetworkResponse<SearchUsersSeedList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchUsersEditionList.json")
    @GET("/people/{username}/lists/{olid}/editions.json")
    suspend fun searchUsersEditionList(
        @Path("username") username: String,
        @Path("olid") olid: String,
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<SearchUsersEditionList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchUsersSubjectsList.json")
    @GET("/people/{username}/lists/{olid}/subjects.json")
    suspend fun searchUsersSubjectsList(
        @Path("username") username: String,
        @Path("olid") olid: String,
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<SearchUsersSubjectList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchOlidBooksList.json")
    @GET("/books/{olid}/lists.json")
    suspend fun searchOlidBooksList(
        @Path("olid") olid: String
    ): NetworkResponse<SearchUsersList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchOlidWorksList.json")
    @GET("/works/{olid}/lists.json")
    suspend fun searchOlidWorksList(
        @Path("olid") olid: String
    ): NetworkResponse<SearchUsersList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchOlidAuthorsList.json")
    @GET("/authors/{olid}/lists.json")
    suspend fun searchOlidAuthorsList(
        @Path("olid") olid: String
    ): NetworkResponse<SearchUsersList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchSubjectPlaceList.json")
    @GET("/subjects/place:{location}/lists.json")
    suspend fun searchSubjectsPlaceList(
        @Path("location") location: String
    ): NetworkResponse<SearchUsersList.Response, ErrorResponse.Response>

    @Mock @MockResponse(body = "/v1/list/SearchQueryList.json")
    @GET("/search/lists.json")
    suspend fun searchQueryList(
        @Query("q") query: String,
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): NetworkResponse<SearchUsersList.Response, ErrorResponse.Response>

    @POST("/account/login")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun authenticate(
        @Query("username") username: String,
        @Query("password") password: String,
    ): NetworkResponse<Login.Response, String>

    @POST("/people/{username}/lists")
    @Headers("Content-Type: application/json")
    suspend fun createList(
        @Path("username") username: String,
        @Body createList: CreateList.Request
    ): NetworkResponse<CreateList.Response, String>

    @Deprecated("Doesn't support POST requests, although docs says it should!")
    @POST("/people/{username}/list/{olid}/delete.json")
    @Headers("Content-Type: application/json")
    suspend fun deleteList(
        @Path("username") username: String,
        @Path("olid") olid: String
    ): NetworkResponse<String, String>

    @Deprecated("This is not yet implemented!")
    @PUT("/people/{username}/list/{olid}")
    @Headers("Content-Type: application/json")
    suspend fun updateList(
        @Path("username") username: String,
        @Path("olid") olid: String,
        @Body createList: CreateList.Request
    ): NetworkResponse<CreateList.Response, String>
}