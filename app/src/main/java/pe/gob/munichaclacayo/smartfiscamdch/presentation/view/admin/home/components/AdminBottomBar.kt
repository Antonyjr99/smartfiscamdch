package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.admin.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController) {
    val screens = listOf(
        AdminScreen.CategoryList,
        AdminScreen.ProductList,
        AdminScreen.Profile
    )
    val navBackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination && currentDestination != null) {
        NavigationBar {
            screens.forEach { screen ->
                AdminBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination, // Ahora está garantizado que no es nulo
                    navController = navController
                )
            }
        }
    }
}
