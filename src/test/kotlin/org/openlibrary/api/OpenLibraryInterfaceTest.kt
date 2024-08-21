package org.retroachivements.api

import co.infinum.retromock.Retromock
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.openlibrary.api.test.ResourceBodyFactory
import org.openlibrary.org.openlibrary.api.Identifier
import org.openlibrary.org.openlibrary.api.OpenLibraryClient
import org.openlibrary.org.openlibrary.api.OpenLibraryInterface
import org.openlibrary.org.openlibrary.api.data.Partner
import org.openlibrary.org.openlibrary.api.data.SearchChangesQuery
import kotlin.test.assertNotNull


class OpenLibraryInterfaceTest {

    @Test
    fun `check searchBooksByQuery response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchBooksByQuery("the lord of the rings")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchBooksByTitle response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchBooksByQuery("the lord of the rings")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchBooksByAuthor response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchBooksByAuthor("tolkien", sort = "new")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchMyWantToReadBooks response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchMyWantToReadBooks("mekBot")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchMyCurrentlyReadingBooks response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchMyCurrentlyReadingBooks("mekBot")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchMyAlreadyReadBooks response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchMyAlreadyReadBooks("mekBot")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchWorksEditions response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchWorksEditions("OL45804W")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchWorksBookshelves response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchWorksBookshelves("OL18020194W")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchWorksIsbn response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchWorksIsbn("9780140328721")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchWorksRatings response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchWorksRatings("OL18020194W")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchAuthors response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchAuthors("j k rowling")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchAuthorsWorks response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchAuthorsWorks("OL23919A")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchSubjects response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchSubjects("love")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchPartner response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchPartner(Partner.isbn, "0596156715")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchPartners response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchPartners("id:1;lccn:50006784|olid:OL6179000M;lccn:55011330")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchRecentChanges response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchRecentChanges()

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchChanges response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchChanges(SearchChangesQuery(year = 2019, month = 8, type = SearchChangesQuery.Type.merge_author))

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchUsersList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchUsersList("george08")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchUsersList with OLID response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchUsersList("george08", "OL13L")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchUsersSeedList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchUsersSeedList("george08", "OL13L")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchUsersEditionList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchUsersEditionList("george08", "OL13L")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchUsersSubjectsList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchUsersSubjectsList("george08", "OL13L")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchOlidBooksList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchOlidBooksList("OL1M")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchOlidWorksList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchOlidWorksList("OL8721462W")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchOlidAuthorsList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchOlidAuthorsList("OL1A")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchSubjectsPlaceList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchSubjectsPlaceList("san_francisco")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    @Test
    fun `check searchQueryList response parser`() {

        runBlocking {
            val api = createMockedApi()

            val result = api.searchQueryList("book")

            assert(result is NetworkResponse.Success)
            assertNotNull((result as NetworkResponse.Success).body)
        }

    }

    private fun createMockedApi(): OpenLibraryInterface {

        val client = OpenLibraryClient(Identifier())
        val retro = client.openClient

        val mockRetrofit: Retromock = Retromock.Builder()
            .defaultBodyFactory(ResourceBodyFactory())
            .retrofit(retro)
            .build()

        return mockRetrofit.create(OpenLibraryInterface::class.java)
    }
}
