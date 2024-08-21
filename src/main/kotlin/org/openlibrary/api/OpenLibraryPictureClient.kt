package org.openlibrary.org.openlibrary.api

import org.openlibrary.api.Identifier
import org.openlibrary.api.OpenLibraryPictureInterface
import org.openlibrary.api.core.CoreClient

class OpenLibraryPictureClient(debugging: Boolean = false, identifier: Identifier)
    : CoreClient("https://covers.openlibrary.org/", identifier, debugging) {

    // the API interface for the client
    val api: OpenLibraryPictureInterface = openClient.create(OpenLibraryPictureInterface::class.java)
}
