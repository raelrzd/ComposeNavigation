package br.com.alura.panucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.panucci.sampledata.sampleProducts
import br.com.alura.panucci.ui.screens.DrinksListScreen

fun NavGraphBuilder.drinksScreen(navController: NavController) {
    composable(AppDestination.Drinks.route) {
        DrinksListScreen(
            products = sampleProducts,
            onNavigateToDetails = { product ->
                navController.navigate("${AppDestination.ProductDetails.route}/${product.id}")
            },
        )
    }
}