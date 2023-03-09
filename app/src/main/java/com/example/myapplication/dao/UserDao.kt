package com.example.myapplication.dao

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.Model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertData(userData: User)
    @Query("Select * from user_table order by id ASC")
    fun readData():LiveData<List<User>>
}