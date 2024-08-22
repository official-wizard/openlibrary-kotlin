
<p align="center" dir="auto">
    <a href="https://openlibrary.org/developers/api" rel="nofollow">
        <img src="https://i.imgur.com/93jMMZa.png" width="200" alt="OpenLibrary API Icon" style="max-width: 100%;"/>
    </a>
</p>

<h1 align="center"><a href="https://openlibrary.org/developers/api">OpenLibrary.org</a> Client for Kotlin</h1>

## Installation

To begin, import the library using jitpack.io.

You can include jitpack in your `pom.xml` by adding the following jitpack repository:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://www.jitpack.io</url>
</repository>
```

Then add this `openlibrary-kotlin` dependency to your `pom.xml` project!

```xml
<dependency>    
    <groupId>com.github.official-wizard</groupId>    
    <artifactId>openlibrary-kotlin</artifactId>    
    <version>1.0.0</version>
</dependency>
```

## Usage

### Basic Usage

```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryClient = OpenLibraryClient(identifier).api

// access the api interface in `api`
```

### Authentication
Some endpoints require you to be authenticated, e.g. the ones for creating lists.
You can easily authenticate your client by doing the following.

```kotlin
// create client instance
val client = OpenLibraryClient(Identifier()).api

// send the authentication request
val authentication: NetworkResponse<Login.Response, Unit> =
    client.authenticate(username = "<email>", password = "<password>")

// an error occurred
if (authentication !is NetworkResponse.Success) {

    if (authentication is NetworkResponse.ServerError) {
        // the credentials you provided are most likely invalid, refer to response code for further
        // information
    }

    if (authentication is NetworkResponse.UnknownError) {
        // an unknown error occurred while authenticating, handle [authentication] result
    }

    // ...

    return
}

val authenticationResponse: Login.Response = authentication.body
if (authenticationResponse.authenticated) {
    // we've authenticated our [client], this only needs to be done once per instance
}
```

## More Examples

### Book Search

<details>
<summary>Query</summary>
<br>

| Name   | Type   | Description                                                     | Example               | required |
|:-------|:-------|:----------------------------------------------------------------|:----------------------|----------|
| query  | String | The query you'd like to search for.                             | The Lord of The Rings | yes      |
| sort   | String | How you'd like to sort the query, by default it uses relevancy. | new                   | no       |
| lang   | String | The users language as a two letter (ISO 639-1) language code.   | en                    | no       |
| offset | Long   | offset the list by the provided amount.                         | 50                    | no       |
| page   | Long   | The page you'd like to traverse to.                             | 0                     | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchBooks.Response, SearchBooks.Response>
    = api.searchBooksByQuery(query = "The Lord of the Rings")

if (search is NetworkResponse.Success) {
    val searchResult: SearchBooks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

<details>
<summary>Title</summary>
<br>

| Name   | Type   | Description                                                     | Example               | required |
|:-------|:-------|:----------------------------------------------------------------|:----------------------|----------|
| title  | String | The title you'd like to search for.                             | The Lord of The Rings | yes      |
| sort   | String | How you'd like to sort the query, by default it uses relevancy. | new                   | no       |
| lang   | String | The users language as a two letter (ISO 639-1) language code.   | en                    | no       |
| offset | Long   | offset the list by the provided amount.                         | 50                    | no       |
| page   | Long   | The page you'd like to traverse to.                             | 0                     | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchBooks.Response, SearchBooks.Response>
    = api.searchBooksByTitle(title = "The Lord of the Rings")

if (search is NetworkResponse.Success) {
    val searchResult: SearchBooks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

<details>
<summary>Author</summary>
<br>

| Name   | Type   | Description                                                     | Example     | required |
|:-------|:-------|:----------------------------------------------------------------|:------------|----------|
| author | String | The author you'd like to search for.                            | J K Rowling | yes      |
| sort   | String | How you'd like to sort the query, by default it uses relevancy. | new         | no       |
| lang   | String | The users language as a two letter (ISO 639-1) language code.   | en          | no       |
| offset | Long   | offset the list by the provided amount.                         | 50          | no       |
| page   | Long   | The page you'd like to traverse to.                             | 0           | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchBooks.Response, SearchBooks.Response>
    = api.searchBooksByAuthor(author = "J K Rowling")

if (search is NetworkResponse.Success) {
    val searchResult: SearchBooks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

---

### Profile Search (My)

<details>
<summary>Want To Read Books</summary>
<br>

| Name     | Type   | Description                                                     | Example | required |
|:---------|:-------|:----------------------------------------------------------------|:--------|----------|
| username | String | The username you'd like to search for.                          | mokBot  | yes      |
| sort     | String | How you'd like to sort the query, by default it uses relevancy. | new     | no       |
| lang     | String | The users language as a two letter (ISO 639-1) language code.   | en      | no       |
| offset   | Long   | offset the list by the provided amount.                         | 50      | no       |
| page     | Long   | The page you'd like to traverse to.                             | 0       | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchMyBooks.Response, SearchMyBooks.Response>
    = api.searchMyWantToReadBooks(username = "mokBot")

if (search is NetworkResponse.Success) {
    val searchResult: SearchMyBooks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

<details>
<summary>Currently Reading Books</summary>
<br>

| Name     | Type   | Description                                                     | Example | required |
|:---------|:-------|:----------------------------------------------------------------|:--------|----------|
| username | String | The username you'd like to search for.                          | mokBot  | yes      |
| sort     | String | How you'd like to sort the query, by default it uses relevancy. | new     | no       |
| lang     | String | The users language as a two letter (ISO 639-1) language code.   | en      | no       |
| offset   | Long   | offset the list by the provided amount.                         | 50      | no       |
| page     | Long   | The page you'd like to traverse to.                             | 0       | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchMyBooks.Response, SearchMyBooks.Response>
    = api.searchMyCurrentlyReadingBooks(username = "mokBot")

if (search is NetworkResponse.Success) {
    val searchResult: SearchMyBooks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

<details>
<summary>Already Read Books</summary>
<br>

| Name     | Type   | Description                                                     | Example | required |
|:---------|:-------|:----------------------------------------------------------------|:--------|----------|
| username | String | The username you'd like to search for.                          | mokBot  | yes      |
| sort     | String | How you'd like to sort the query, by default it uses relevancy. | new     | no       |
| lang     | String | The users language as a two letter (ISO 639-1) language code.   | en      | no       |
| offset   | Long   | offset the list by the provided amount.                         | 50      | no       |
| page     | Long   | The page you'd like to traverse to.                             | 0       | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchMyBooks.Response, SearchMyBooks.Response>
    = api.searchMyAlreadyReadBooks(username = "mokBot")

if (search is NetworkResponse.Success) {
    val searchResult: SearchMyBooks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

---

<details>
<summary>Create List</summary>
<br>

> A call to `createList` in this manner will will update a pre-existing list with the details provided!

> **NOTE** You must have the client authenticated to do this!

**Available Parameters**

| Name       | Type               | Description                                          | Example  |
|:-----------|:-------------------|:-----------------------------------------------------|:---------|
| username   | String             | The username authenticated for the session           | username |
| olid       | String             | The OLID (Open Library ID) of the list               | OL01L    |
| createList | CreateList.Request | The request object with details to create list with. | N/A      |

**Example**
```kotlin
// create client instance
val client = OpenLibraryClient(Identifier()).api

// send the authentication request
val authentication: NetworkResponse<Login.Response, Unit> =
    client.authenticate(username = "<email>", password = "<password>")

// an error occurred
if (authentication !is NetworkResponse.Success) {

    if (authentication is NetworkResponse.ServerError) {
        // the credentials you provided are most likely invalid, refer to response code for further
        // information
    }

    if (authentication is NetworkResponse.UnknownError) {
        // an unknown error occurred while authenticating, handle [authentication] result
    }

    // ...

    return
}

val authenticationResponse: Login.Response = authentication.body
if (authenticationResponse.authenticated) {
    // we've authenticated our [client], this only needs to be done once per instance

    // make sure we have a valid username to work with
    val username = authenticationResponse.username
    if (username != null) {

        // send request to server
        val createList = client.createList(
            username = username,
            createList = CreateList.Request(
                "<new name>",
                "<new description>"
            )
        )

        if (createList !is NetworkResponse.Success) {
           // handle errors
            return
        }
        
        // handle our result
        val result: CreateList.Response = createList.body
    }
}
```

</details>


### Works Search

<details>
<summary>Works</summary>
<br>

| Name   | Type   | Description                             | Example | required |
|:-------|:-------|:----------------------------------------|:--------|----------|
| olid   | String | the OLID to the works.                  | OL01W   | yes      |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchWorks.Response, ErrorResponse.Response>
    = api.searchWorks(olid = "OL01W")

if (search is NetworkResponse.Success) {
    val searchResult: SearchWorks.Response = search.body
    // handle [searchResult] as you wish
}

```

</details>

<details>
<summary>Editions</summary>
<br>

| Name   | Type   | Description                             | Example | required |
|:-------|:-------|:----------------------------------------|:--------|----------|
| olid   | String | the OLID to the works.                  | OL01W   | yes      |
| offset | Long   | offset the list by the provided amount. | 50      | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchWorksEditions.Response, ErrorResponse.Response>
    = api.searchWorksEditions(olid = "OL01W")

if (search is NetworkResponse.Success) {
    val searchResult: SearchWorksEditions.Response = search.body
    // handle [searchResult] as you wish
}
```
</details>

<details>
<summary>Bookshelves</summary>
<br>

| Name   | Type   | Description                             | Example | required |
|:-------|:-------|:----------------------------------------|:--------|----------|
| olid   | String | the OLID to the works.                  | OL01W   | yes      |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchWorksBookshelves.Response, ErrorResponse.Response>
    = api.searchWorksBookshelves(olid = "OL01W")

if (search is NetworkResponse.Success) {
    val searchResult: SearchWorksBookshelves.Response = search.body
    // handle [searchResult] as you wish
}
```

</details>

<details>
<summary>Ratings</summary>
<br>

| Name   | Type   | Description                             | Example | required |
|:-------|:-------|:----------------------------------------|:--------|----------|
| olid   | String | the OLID to the works.                  | OL01W   | yes      |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchWorksRatings.Response, ErrorResponse.Response>
    = api.searchWorksRatings(olid = "OL01W")

if (search is NetworkResponse.Success) {
    val searchResult: SearchWorksRatings.Response = search.body
    // handle [searchResult] as you wish
}
```

</details>

<details>
<summary>Isbn</summary>
<br>

| Name | Type   | Description            | Example | required |
|:-----|:-------|:-----------------------|:--------|----------|
| isbn | String | the isbn to the works. | 0000    | yes      |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchIsbn.Response, ErrorResponse.Response>
    = api.searchWorksIsbn(isbn = "0000")

if (search is NetworkResponse.Success) {
    val searchResult: SearchIsbn.Response = search.body
    // handle [searchResult] as you wish
}
```

</details>

### Authors Search

<details>
<summary>Authors</summary>
<br>

| Name  | Type   | Description                             | Example     | required |
|:------|:-------|:----------------------------------------|:------------|----------|
| query | String | author's query you'd like to serch for. | J K Rowling | yes      |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchAuthors.Response, SearchAuthors.Response>
    = api.searchAuthors(query = "<author query>")

if (search is NetworkResponse.Success) {
    val searchResult: SearchAuthors.Response = search.body
    // handle [searchResult] as you wish
}
```

</details>


### Subjects Search

<details>
<summary>Subject</summary>
<br>

| Name             | Type    | Description                           | Example   | required |
|:-----------------|:--------|:--------------------------------------|:----------|----------|
| subject          | String  | The subject you'd like to search for. | Love      | yes      |
| details          | Boolean | Include details about the subject.    | True      | no       |
| publishedInRange | String  | Date range for punishments.           | 2008-2010 | no       |
| limit            | Int     | Limit the amount of results to return | 50        | no       |
| offset           | Int     | Offset the results to jump to.        | 0         | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchSubjects.Response, SearchSubjects.Response>
    = api.searchSubjects(subject = "love")

if (search is NetworkResponse.Success) {
    val searchResult: SearchSubjects.Response = search.body
    // handle [searchResult] as you wish
}
```

</details>


### Partners Search

<details>
<summary>Partner</summary>
<br>

| Name             | Type    | Description                           | Example      | required |
|:-----------------|:--------|:--------------------------------------|:-------------|----------|
| partner          | Partner | A supported partner to query with.    | Partner.isbn | yes      |
| partnerId        | String  | The partner ID to query with.         | 01a0         | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchPartner.Response, SearchPartner.Response>
    = api.searchPartner(partner = Partner.isbn, partnerId = "01s3")

if (search is NetworkResponse.Success) {
    val searchResult: SearchPartner.Response = search.body
    // handle [searchResult] as you wish
}
```
</details>


<details>
<summary>Partners</summary>
<br>

| Name        | Type   | Description                                       | Example                                           | required |
|:------------|:-------|:--------------------------------------------------|:--------------------------------------------------|----------|
| requestList | String | List of partners and the IDs you'd like to query. | id:1;lccn:50006784\|olid:OL6179000M;lccn:55011330 | yes      |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<SearchPartner.Response, SearchPartner.Response>
    = api.searchPartners(requestList = "id:1;lccn:50006784|olid:OL6179000M;lccn:55011330")

if (search is NetworkResponse.Success) {
    val searchResult: Map<String, SearchPartner.Response> 
        = search.body
    // handle [searchResult] as you wish
}
```
</details>

### Changes Search

<details>
<summary>Recent</summary>
<br>

| Name   | Type    | Description                           | Example | required |
|:-------|:--------|:--------------------------------------|:--------|----------|
| bot    | Boolean | Ignore changes made by bots.          | True    | no       |
| limit  | Int     | Limit the amount of results to return | 50      | no       |
| offset | Int     | Offset the results to jump to.        | 0       | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<List<SearchChanges.Response>, ErrorResponse.Response>
    = api.searchRecentChanges()

if (search is NetworkResponse.Success) {
    val searchResult: List<SearchChanges.Response>
        = search.body
    // handle [searchResult] as you wish
}
```
</details>


<details>
<summary>Type</summary>
<br>

| Name   | Type               | Description                           | Example                         | required |
|:-------|:-------------------|:--------------------------------------|:--------------------------------|----------|
| query  | SearchChangesQuery | Change type.                          | SearchChangesQuery(year = 2008) | yes      |
| bot    | Boolean            | Ignore changes made by bots.          | True                            | no       |
| limit  | Int                | Limit the amount of results to return | 50                              | no       |
| offset | Int                | Offset the results to jump to.        | 0                               | no       |

**Example**
```kotlin
val identifier: Identifier = Identifier("<client user agent>")
val api: OpenLibraryInterface = OpenLibraryClient(identifier).api

val search: NetworkResponse<List<SearchChanges.Response>, ErrorResponse.Response>
    = api.searchChanges(query = SearchChangesQuery(year = 2008))

if (search is NetworkResponse.Success) {
    val searchResult: List<SearchChanges.Response>
        = search.body
    // handle [searchResult] as you wish
}
```
</details>
