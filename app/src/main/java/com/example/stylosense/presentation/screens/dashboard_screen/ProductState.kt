package com.example.stylosense.presentation.screens.dashboard_screen

import com.example.stylosense.domain.model.ProductModel

data class ProductState(
    val isLoading: Boolean = false,
    val product: List<ProductModel>? = null,
    val errorMessage: String = ""
)
