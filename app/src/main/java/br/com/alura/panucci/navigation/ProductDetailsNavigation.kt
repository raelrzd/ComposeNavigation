package br.com.alura.panucci.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.panucci.sampledata.sampleProducts
import br.com.alura.panucci.ui.screens.ProductDetailsScreen

const val TAG = "ProductDetailsNavigation"

fun NavGraphBuilder.productDetailsScreen(navController: NavController) {
    composable("${AppDestination.ProductDetails.route}/{productId}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("productId")
        sampleProducts.find { it.id == id }?.let { product ->
            Log.i(TAG, "onCreate: product - $product")
            ProductDetailsScreen(
                product = product,
                onNavigateToCheckout = {
                    navController.navigate(AppDestination.Checkout.route)
                },
            )
        } ?: LaunchedEffect(Unit) {
            navController.navigateUp()
        }
    }
}