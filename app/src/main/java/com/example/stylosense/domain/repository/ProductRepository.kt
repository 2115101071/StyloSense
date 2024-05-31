package com.example.stylosense.domain.repository

import com.example.stylosense.domain.model.ProductModel

interface ProductRepository {
    suspend fun getProduct(): List<ProductModel>? = null
    suspend fun getProductDetail(id: Int): ProductModel? = null
}