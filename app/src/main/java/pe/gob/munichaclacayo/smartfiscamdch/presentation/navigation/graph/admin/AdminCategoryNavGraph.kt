package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.admin


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.admin.AdminCategoryScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.AdminCategoryCreateScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.AdminCategoryUpdateScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){
        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController )
        }
        composable(
            route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument("category"){
                    type=NavType.StringType
                })
            ){
            it.arguments?.getString("category")?.let {
                AdminCategoryUpdateScreen(navController, it )
            }
        }


    }
}