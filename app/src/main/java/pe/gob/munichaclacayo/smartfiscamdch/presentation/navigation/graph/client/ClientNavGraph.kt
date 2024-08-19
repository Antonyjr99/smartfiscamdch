package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.profile.ProfileNavGraph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.client.ClientScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.Asociacion.list.ClientCategoryListScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.product.ClientProductListScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {

        composable(route = ClientScreen.ProductList.route) {
            ClientProductListScreen(navController)
        }

        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen(navController)
        }



        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }

        ProfileNavGraph(navController)

    }
}