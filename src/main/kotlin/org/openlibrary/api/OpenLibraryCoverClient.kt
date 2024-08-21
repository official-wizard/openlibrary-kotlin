package org.openlibrary.org.openlibrary.api

import org.openlibrary.api.Identifier
import org.openlibrary.api.OpenLibraryCoverInterface
import org.openlibrary.api.core.CoreClient

class OpenLibraryCoverClient(debugging: Boolean = false, identifier: Identifier)
    : CoreClient("https://covers.openlibrary.org/", identifier, debugging) {

    // the API interface for the client
    val api: OpenLibraryCoverInterface = openClient.create(OpenLibraryCoverInterface::class.java)
}
