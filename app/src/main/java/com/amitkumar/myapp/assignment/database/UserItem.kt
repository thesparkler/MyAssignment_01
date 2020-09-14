package com.amitkumar.myapp.assignment.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.amitkumar.myapp.assignment.models.*

@Entity(tableName = "users")
data class UserItem(

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "title")
    var title: Name? = null,

    @ColumnInfo(name = "first")
    var first: Name? = null,

    @ColumnInfo(name = "last")
    var last: Name? = null,

    @ColumnInfo(name = "gender")
    var gender: String? = null,

    @ColumnInfo(name = "age")
    var age: DOB? = null,

    @ColumnInfo(name = "nat")
    var nat: Nationality? = null,

    @ColumnInfo(name = "profile_image")
    var large: Picture? = null

)