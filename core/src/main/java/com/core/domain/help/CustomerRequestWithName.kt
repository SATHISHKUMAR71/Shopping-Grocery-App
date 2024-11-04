package com.core.domain.help

data class CustomerRequestWithName(
    val helpId:Int,
    val userId:Int,
    val requestedDate:String,
    val orderId:Int,
    val request:String,
    val userFirstName:String,
    val userLastName:String,
    val userEmail:String,
    val userPhone:String
)