package br.com.alura.panucci.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.alura.panucci.sampledata.sampleProducts
import br.com.alura.panucci.ui.screens.ProductDetailsScreen

const val TAG = "ProductDetailsNavigation"
internal const val productDetailsRoute = "productDetails"
internal const val productIdArgument = "productId"

fun NavGraphBuilder.productDetailsScreen(navController: NavHostController) {
    composable("$productDetailsRoute/{$productIdArgument}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString(productIdArgument)
        sampleProducts.find { it.id == id }?.let { product ->
            Log.i(TAG, "onCreate: product - $product")
            ProductDetailsScreen(
                product = product,
                onNavigateToCheckout = {
                    navController.navigateToCheckout()
                },
            )
        } ?: LaunchedEffect(Unit) {
            navController.navigateUp()
        }
    }
}

fun NavController.navigateToProductDetails(id: String) {
    navigate("$productDetailsRoute/$id")
}