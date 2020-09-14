package com.amitkumar.myapp.assignment.models

import android.arch.persistence.room.Embedded

data class UserProfile(
    var gender: String?,

    @Embedded
    var name: Name?,

    @Embedded
    var dob: DOB?,

    @Embedded
    var image: Picture?,

    @Embedded
    var country: Nationality?
) {}

data class Name(
    var title: String?,
    var first: String?,
    var last: String?
) {}


data class DOB(
    var date: String?,
    var age: Int?
) {}

data class Picture(
    var large: String?,
    var medium: String?,
    var thumbnail: String?
) {}

data class Nationality(
    var nat: String?
) {}
