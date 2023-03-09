package com.example.myapplication.Viewmodel

import android.app.Application
import android.service.autofill.UserData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Database.UserDatabase
import com.example.myapplication.Model.User
import com.example.myapplication.Repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

     val readAllData:LiveData<List<User>>
    private  val repository:UserRepository
    init {
        val userdao=UserDatabase.getDatabase(application).userdao()
        repository= UserRepository(userdao)
        readAllData=repository.readAllData
    }

    fun addUser(userData:User){
      viewModelScope.launch ( Dispatchers.IO){
          repository.insertUser(userData)
      }
    }
}