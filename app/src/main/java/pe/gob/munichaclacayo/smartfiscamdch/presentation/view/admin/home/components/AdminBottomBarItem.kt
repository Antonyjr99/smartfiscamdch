package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.home.components


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.admin.AdminScreen

@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination: NavDestination,
    navController: NavHostController
){
    //
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "")
            },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = LocalContentColor.current,
            unselectedIconColor = LocalContentColor.current.copy(alpha = 0.6f)
        ),
        onClick = {
            navController.navigate(route = screen.route){
                popUpTo(navController.graph.findStartDestination().id)
            }
        }
    )
}