package com.example.shoppinggroceryapp.framework.db.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId:Int,
    val userImage:String,
    val userFirstName:String,
    val userLastName:String,
    val userEmail:String,
    val userPhone:String,
    val userPassword:String,
    val dateOfBirth:String,
    val isRetailer:Boolean
)