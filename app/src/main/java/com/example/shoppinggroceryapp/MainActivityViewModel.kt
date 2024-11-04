package com.example.shoppinggroceryapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.shoppinggroceryapp.MainActivity.Companion.cartId
import com.example.shoppinggroceryapp.MainActivity.Companion.userId
import com.example.shoppinggroceryapp.framework.db.dao.UserDao
import com.example.shoppinggroceryapp.framework.db.database.AppDatabase.Companion.getAppDatabase
import com.example.shoppinggroceryapp.framework.db.entity.order.CartMappingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(var userDao:UserDao): ViewModel()  {
    fun initDb(){
        viewModelScope.launch(Dispatchers.IO){
            userDao.initDB()
        }
    }
    fun assignCart(){
        viewModelScope.launch(Dispatchers.IO) {
            val cart: CartMappingEntity? = userDao.getCartForUser(userId.toInt())
            if (cart == null) {
                userDao.addCartForUser(CartMappingEntity(0, userId = userId.toInt(), "available"))
                val newCart = userDao.getCartForUser(userId.toInt())
                cartId = newCart?.cartId?:-1
            } else {
                cartId = cart.cartId
            }
        }
    }
}