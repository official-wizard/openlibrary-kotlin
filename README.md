
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

<details>
<summary>Create List</summary>
<br>

> A call to updateList() in this manner will will update a pre-existing list with the details provided!

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
