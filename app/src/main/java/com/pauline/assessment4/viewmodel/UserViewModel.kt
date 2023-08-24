package com.pauline.assessment4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauline.assessment4.model.User
import com.pauline.assessment4.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel () {
    var userRepository = UserRepository()
    var userLiveData = MutableLiveData<List<User>>()
    var errorLiveData = MutableLiveData<String>()

   fun fetchUsers(){
       viewModelScope.launch {
           try {
               val response = userRepository.getUsers()
               if (response.isSuccessful) {
                   val userlist = response.body() ?: emptyList()
                   userLiveData.postValue(userlist)
               } else {
                   errorLiveData.postValue(response.errorBody()?.string())
               }
           } catch (e: Exception) {
               errorLiveData.postValue(e.message)
           }
       }
   }
   }
//        viewModelscope.launch{
//            val response = userRepository.getUsers()
//            if (response.isSuccessful){
////                userLiveData.postValue(response.body()?.userS)
//                val userlist=response.body()?: emptyList()
//                userLiveData.postValue(userlist as List<User>)
//            }
//            else{
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }

