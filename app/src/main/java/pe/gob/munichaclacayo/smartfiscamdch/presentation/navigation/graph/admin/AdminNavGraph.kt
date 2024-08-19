package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.profile.ProfileNavGraph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.admin.AdminScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list.AdminCategoryListScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.product.list.AdminProductListScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController= navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.CategoryList.route
    ){
        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen(navController)
        }
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen(navController)
        }
        composable(route = AdminScreen.Profile.route){
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        AdminCategoryNavGraph(navController)
    }
}