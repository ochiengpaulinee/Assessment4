package com.pauline.assessment4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauline.assessment4.databinding.ActivityMainBinding
import com.pauline.assessment4.model.User
import com.pauline.assessment4.model.UserAdapter
import com.pauline.assessment4.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    val userViewModel:UserViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        userViewModel.fetchUsers()
        userViewModel.userLiveData.observe(this, Observer { userList->
            var userAdapter = UserAdapter(userList ?: emptyList())
            binding.rvItems.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvItems.adapter = userAdapter
            Toast.makeText(baseContext, "fetched successfully", Toast.LENGTH_LONG).show()
        })
        userViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}
