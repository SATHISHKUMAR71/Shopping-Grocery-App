package com.example.shoppinggroceryapp.views.userviews.ordercheckoutviews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.core.domain.products.CartWithProductData
import com.example.shoppinggroceryapp.R
import com.example.shoppinggroceryapp.framework.db.entity.products.CartWithProductDataEntity
import com.example.shoppinggroceryapp.helpers.imagehandlers.SetProductImage
import kotlinx.coroutines.launch

import java.io.File

class ProductViewAdapter(var file:File,var fragment:Fragment):RecyclerView.Adapter<ProductViewAdapter.ProductViewPagerHolder>() {

    companion object{
        var productsList = listOf<CartWithProductData>()
    }
    inner class ProductViewPagerHolder(productView:View):RecyclerView.ViewHolder(productView){
        val imageView = productView.findViewById<ImageView>(R.id.imageViewProductViewPager)
        val productName = productView.findViewById<TextView>(R.id.productNameOrderSummary)
        val productQuantity = productView.findViewById<TextView>(R.id.productQuantityOrderSummary)
        val orderSummaryPrice = productView.findViewById<TextView>(R.id.priceInOrderSummary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewPagerHolder {
        return ProductViewPagerHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_view_pager,parent,false))
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductViewPagerHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.count).text = productsList[position].totalItems.toString()
        holder.productName.text = productsList[position].productName
        holder.productQuantity.text = productsList[position].productQuantity
        var price = "₹${productsList[position].unitPrice}"
        holder.orderSummaryPrice.text = price
        var url = productsList[position].mainImage
        fragment.lifecycleScope.launch {
            SetProductImage.setImageView(holder.imageView,url?:"",file)
        }
    }
}