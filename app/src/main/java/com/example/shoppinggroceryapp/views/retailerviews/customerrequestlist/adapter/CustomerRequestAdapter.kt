package com.example.shoppinggroceryapp.views.retailerviews.customerrequestlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.core.domain.help.CustomerRequestWithName
import com.example.shoppinggroceryapp.R
import com.example.shoppinggroceryapp.helpers.dategenerator.DateGenerator
import com.example.shoppinggroceryapp.views.retailerviews.customerrequestlist.CustomerRequestViewModel

import com.example.shoppinggroceryapp.views.retailerviews.customerrequestlist.CustomerRequestListFragment

class CustomerRequestAdapter(var customerReqViewModel: CustomerRequestViewModel, var fragment: Fragment) :RecyclerView.Adapter<CustomerRequestAdapter.CustomerRequestHolder>(){

    companion object {
        var requestList = mutableListOf<CustomerRequestWithName>()
    }
    inner class CustomerRequestHolder(customerView:View):RecyclerView.ViewHolder(customerView){
        val reqDate = customerView.findViewById<TextView>(R.id.requestedDate)
        val name = customerView.findViewById<TextView>(R.id.customerName)
        var request = customerView.findViewById<TextView>(R.id.customerRequestText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerRequestHolder {
        return CustomerRequestHolder(LayoutInflater.from(parent.context).inflate(R.layout.customer_request_view,parent,false))
    }

    override fun getItemCount(): Int {
        return requestList.size
    }

    override fun onBindViewHolder(holder: CustomerRequestHolder, position: Int) {
        val date = "Requested On: ${DateGenerator.getDayAndMonth(requestList[position].requestedDate)}"
        val name:String = if(requestList[position].userLastName.isEmpty()){
            "Customer Name: ${requestList[position].userFirstName}"
        } else{
            "Customer Name: ${requestList[position].userFirstName} ${requestList[position].userLastName}"
        }
        holder.name.text = name
        holder.reqDate.text = date
        holder.request.text = requestList[position].request
        holder.itemView.setOnClickListener {
            customerReqViewModel.getOrderDetails(requestList[position].orderId)
            CustomerRequestListFragment.customerName = name
            CustomerRequestListFragment.customerEmail = requestList[position].userEmail
            CustomerRequestListFragment.customerPhone = requestList[position].userPhone
            CustomerRequestListFragment.customerRequest = requestList[position].request
            CustomerRequestListFragment.requestedDate = DateGenerator.getDayAndMonth(requestList[position].requestedDate)
        }
    }
}