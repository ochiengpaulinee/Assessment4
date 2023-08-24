package com.pauline.assessment4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauline.assessment4.model.User
import com.pauline.assessment4.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel {
    var userRepository = UserRepository()
    var userLiveData = MutableLiveData<List<User>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchUsers(){
        val viewModelscope = null
        viewModelscope.launch{
            val response = userRepository.getUsers()
            if (response.isSuccessful){
                userLiveData.postValue(response.body()?.users)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}