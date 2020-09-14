package com.amitkumar.myapp.assignment.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.amitkumar.myapp.assignment.models.UserProfile

@Dao
interface UserDAO {

    @Query("SELECT * FROM users")
    fun fetchAll(): List<UserItem>

    @Insert
    fun insert(albums: ArrayList<UserProfile>)

}