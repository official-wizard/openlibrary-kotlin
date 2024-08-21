package org.openlibrary.api.data.pojo.account

import com.google.gson.annotations.SerializedName

class Login {

    data class Request(

        @SerializedName("username")
        val username: String,

        @SerializedName("password")
        val password: String
    )

    data class Response(

        @SerializedName("authenticated")
        val authenticated: Boolean,

        @SerializedName("session")
        val session: String?
    )
}