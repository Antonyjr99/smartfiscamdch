package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.client.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController) {
    val screens = listOf(
        ClientScreen.CategoryList,
        ClientScreen.ProductList,
        ClientScreen.Profile
    )
    val navBackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination && currentDestination != null) {
        NavigationBar {
            screens.forEach { screen ->
                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination, // Ahora está garantizado que no es nulo
                    navController = navController
                )
            }
        }
    }
}
