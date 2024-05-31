package com.example.stylosense.presentation.screens.product_detail_screen

import com.example.stylosense.domain.model.ProductModel

data class ProductDetailState(
    val isLoading: Boolean = false,
    val productDetail: ProductModel? = null,
    val errorMessage: String = ""
)