package com.pauline.assessment4.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.pauline.assessment4.databinding.UserItemBinding
import com.squareup.picasso.Picasso

class UserAdapter(var userList: List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var currentUser = userList[position]
        holder.bind(currentUser)
    }

    inner class UserViewHolder(private val binding: UserItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(currentUser: User){
            binding.apply {
                tvId.text = currentUser.id.toString()
                tvTitle.text = currentUser.title
                tvBody.text = currentUser.body
            }

        }

    }
}


