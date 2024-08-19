package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.roles.RolesScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.home.AdminHomeScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.home.ClientHomeScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph( navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }

        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }
        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}