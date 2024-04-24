package br.com.alura.panucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.panucci.sampledata.sampleProducts
import br.com.alura.panucci.ui.screens.CheckoutScreen

fun NavGraphBuilder.checkoutScreen(navController: NavController) {
    composable(AppDestination.Checkout.route) {
        CheckoutScreen(
            products = sampleProducts,
            onPopBackStack = { navController.navigateUp() },
        )
    }
}