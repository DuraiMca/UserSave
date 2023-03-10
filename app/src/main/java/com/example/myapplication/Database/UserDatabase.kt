package com.example.myapplication.Database

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Model.User
import com.example.myapplication.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userdao():UserDao

    companion object{
        @Volatile
        private var INSTANCE:UserDatabase?=null

        fun getDatabase(context: Context):UserDatabase{
          val  tempInstance= INSTANCE;
            if(tempInstance!=null){
                return tempInstance;
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,UserDatabase::class.java,
                    "User_Database"
                ).build()
                INSTANCE=instance
                return instance;
            }
        }
    }

}