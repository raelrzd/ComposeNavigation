package br.com.alura.panucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.panucci.sampledata.sampleProducts
import br.com.alura.panucci.ui.screens.CheckoutScreen

internal const val checkoutRoute = "checkout"

fun NavGraphBuilder.checkoutScreen(navController: NavController) {
    composable(checkoutRoute) {
        CheckoutScreen(
            products = sampleProducts,
            onPopBackStack = { navController.navigateUp() },
        )
    }
}

fun NavController.navigateToCheckout() {
    navigate(checkoutRoute)
}