package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.profile

import androidx.navigation.*
import androidx.navigation.compose.composable
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.profile.ProfileScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, userParam = it)
            }
        }

    }
}