package br.com.alura.panucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.panucci.ui.screens.CheckoutScreen
import br.com.alura.panucci.ui.uistate.CheckoutUiState
import br.com.alura.panucci.ui.viewmodels.CheckoutViewModel

internal const val checkoutRoute = "checkout"

fun NavGraphBuilder.checkoutScreen(navController: NavController) {
    composable(checkoutRoute) {
        val viewModel: CheckoutViewModel = viewModel()
        val uiState: CheckoutUiState by viewModel.uiState.collectAsState()
        CheckoutScreen(
            uiState = uiState,
            onPopBackStack = { navController.navigateUp() },
        )
    }
}

fun NavController.navigateToCheckout() {
    navigate(checkoutRoute)
}