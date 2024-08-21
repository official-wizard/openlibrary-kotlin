package org.openlibrary.org.openlibrary.api

import org.openlibrary.api.Identifier
import org.openlibrary.api.OpenLibraryInterface
import org.openlibrary.api.core.CoreClient


class OpenLibraryClient(identifier: Identifier, debugging: Boolean = false)
    : CoreClient("https://openlibrary.org/", identifier, debugging) {

    // the API interface for the client
    val api: OpenLibraryInterface = openClient.create(OpenLibraryInterface::class.java)
}
