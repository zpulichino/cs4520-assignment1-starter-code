package com.cs4520.assignment1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productNameTV: TextView = view.findViewById(R.id.productNameTextView)
        val expiryDateTV : TextView = view.findViewById(R.id.expiryDateTextView)
        val priceTV : TextView = view.findViewById(R.id.priceTextView)
        val productImageIV: ImageView = view.findViewById(R.id.productImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productNameTV.text = product.name
        holder.priceTV.text = "${product.price}"

        when (product) {
            is Product.Equipment -> {
                holder.expiryDateTV.visibility = View.GONE
                holder.productImageIV.setImageResource(R.mipmap.tools)
                holder.itemView.setBackgroundColor(Color.parseColor("#E06666"))
            }
            is Product.Food -> {
                if (product.expiryDate != null) {
                    holder.expiryDateTV.visibility = View.VISIBLE
                    holder.expiryDateTV.text = product.expiryDate
                } else {
                    holder.expiryDateTV.visibility = View.GONE
                }
                holder.productImageIV.setImageResource(R.mipmap.food)
                holder.itemView.setBackgroundColor(Color.parseColor("#FFD965"))
            }
        }
    }

}
