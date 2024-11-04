package com.example.shoppinggroceryapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinggroceryapp.framework.db.dao.UserDao

class MainActivityViewModelFactory(var userDao:UserDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(userDao) as T
    }
}