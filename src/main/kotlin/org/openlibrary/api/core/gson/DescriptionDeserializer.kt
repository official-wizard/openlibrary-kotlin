package org.openlibrary.api.core.gson

import com.google.gson.*
import org.openlibrary.api.data.pojo.authors.SearchAuthorsWorks
import java.lang.reflect.Type

/**
 * The [DescriptionDeserializer] is important
 * as [SearchAuthorsWorks.Response.Entry.Description] is either a string or an object
 * 
 * This is an inconsistency within the OpenLibrary API we must remedy.
 */
class DescriptionDeserializer : JsonDeserializer<SearchAuthorsWorks.Response.Entry.Description> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): SearchAuthorsWorks.Response.Entry.Description? {
        return when {
            // Handle JSON primitive string case
            json.isJsonPrimitive && json.asJsonPrimitive.isString -> {
                SearchAuthorsWorks.Response.Entry.Description(
                    type = "/type/text",
                    value = json.asString
                )
            }
            // Handle JSON object case
            json.isJsonObject -> {
                val jsonObject = json.asJsonObject
                val type = jsonObject.get("type")?.asString ?: "/type/unknown"
                val value = jsonObject.get("value")?.asString ?: ""

                // Return a new Description object with the extracted fields
                SearchAuthorsWorks.Response.Entry.Description(
                    type = type,
                    value = value
                )
            }
            // Return null if neither case matches
            else -> null
        }
    }
}
