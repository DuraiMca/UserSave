package com.example.myapplication.Repository



import androidx.lifecycle.LiveData
import com.example.myapplication.Model.User
import com.example.myapplication.dao.UserDao

class UserRepository(private val userDao: UserDao) {


    val readAllData: LiveData<List<User>> = userDao.readData()

    suspend fun insertUser(user:User){
        userDao.insertData(user)
    }
}