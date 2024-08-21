package org.openlibrary.api.data

class SearchChangesQuery(
    val year: Int,
    val month: Int? = null,
    val day: Int? = null,
    val type: Type? = null
) {

    override fun toString(): String {
        return StringBuilder().apply {

            // at minimum the year is required
            append(year)

            // append the month if available
            if (month != null) {
                append("/$month")

                // if a day is available append it, you can only use the days if a month is selected
                if (day != null) {
                    append("/$day")
                }
            }

            // filter by update type if available
            if (type != null) {
                append("/${type.key}")
            }

            append(".json")
        }.toString()
    }

    enum class Type(val key: String) {
        revert("revert"),
        add_cover("add-cover"),
        add_book("add-book"),
        edit_book("edit-book"),
        merge_author("merge-authors"),
        update("update"),
        new_account("new-account"),
        register("register"),
        lists("lists")
    }
}