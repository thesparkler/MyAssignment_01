package com.amitkumar.myapp.assignment.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(UserItem::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {

        private var INSTANCE: UserDatabase? = null

        internal fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserDatabase::class.java, "users_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}
