package com.moehan.bitbucketdemo

object Endpoints {
    const val getAllRepositories = "/2.0/repositories"
}

class DB {
    companion object {
        const val DB_NAME = "sample.db"
    }

    object LoginUser {
        const val TABLE_NAME = "login_user"

        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_USERNAME = "username"
        const val COL_PASSWORD = "password"
        const val COL_EMAIL = "email"
        const val COL_COUNTRY = "country"
    }

    object Country {
        const val TABLE_NAME = "country"

        const val COL_ID = "id"
        const val COL_NAME = "name"
    }

    object User {
        const val TABLE_NAME = "user"

        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_USERNAME = "username"
        const val COL_EMAIL = "email"
        const val COL_ADDRESS= "address"
        const val COL_PHONE = "phone"
        const val COL_WEBSITE = "website"
        const val COL_COMPANY = "company"
    }
}