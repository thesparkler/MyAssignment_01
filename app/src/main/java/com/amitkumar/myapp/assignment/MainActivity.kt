package com.amitkumar.myapp.assignment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.amitkumar.myapp.assignment.adapters.UserDataAdapter
import com.amitkumar.myapp.assignment.database.UserDatabase
import com.amitkumar.myapp.assignment.database.UserItem
import com.amitkumar.myapp.assignment.models.UserProfile
import com.amitkumar.myapp.assignment.store.DataStore
import com.amitkumar.myapp.assignment.webservice.Result
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    internal var db: UserDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        retrieveUsers()
    }

    private fun initialize() {

        db = UserDatabase.getDatabase(applicationContext)
    }

    // Refresh the UI with fetched data
    private fun refreshUIWith(userItems: List<UserItem>) {

        val userList = usersListView
        var layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        userList.layoutManager = layoutManager

        val adapter = UserDataAdapter(userItems)
        userList.adapter = adapter
    }

    // Method to save the data to database
    private fun saveWith(users: Array<UserProfile>) {

        doAsync {
            val currentDBPath = getDatabasePath("users_database").absolutePath
            println("DBPath is " + currentDBPath)

            var items = ArrayList<UserProfile>()

            for (user in users) {
                val item = UserItem()
                item.title = user.name
                item.age = user.dob
                items.add(user)
            }
            db?.userDAO()?.insert(items)

            val musicAlbums = db?.userDAO()?.fetchAll()
            activityUiThread {
                longToast("Data Got saved")
                refreshUIWith(musicAlbums!!)
            }
        }
    }

    // Retrieve albums from the API and save it to Database
    fun retrieveUsers() {

        DataStore.getUserDataWith { result
            ->

            if (result != null) {

                when (result.status) {

                    Result.Status.ERROR -> {
                        Toast.makeText(
                            this,
                            "Error:" + result.exception?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    Result.Status.SUCCESS -> {
                        val users = result.data
                        users?.let {
                            saveWith(it)
                        }
                    }
                }

            }
        }
    }
}
