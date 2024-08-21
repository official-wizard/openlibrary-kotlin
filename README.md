
<p align="center" dir="auto">
    <a href="https://openlibrary.org/developers/api" rel="nofollow">
        <img src="https://i.imgur.com/93jMMZa.png" width="200" alt="OpenLibrary API Icon" style="max-width: 100%;"/>
    </a>
</p>

<h1 align="center"><a href="https://openlibrary.org/developers/api">OpenLibrary.com</a> Client for Kotlin</h1>

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
