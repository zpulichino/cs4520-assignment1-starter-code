package com.cs4520.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter : ProductAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        val products = convertProductData(com.cs4520.assignment1.productsDataset)
        productAdapter = ProductAdapter(products)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = productAdapter
    }

    private fun convertProductData(dataset: List<List<Any?>>): List<Product> {
        return dataset.map {
            val productName = it[0] as String
            val productType = it[1] as String
            val expiryDate = it[2] as String?
            val productPrice = it[3] as Int

            when (productType) {
                "Equipment" -> Product.Equipment(productName, productPrice)
                "Food" -> Product.Food(productName, productPrice, expiryDate)
                else -> throw IllegalArgumentException("Unknown product")
            }
        }

    }
}