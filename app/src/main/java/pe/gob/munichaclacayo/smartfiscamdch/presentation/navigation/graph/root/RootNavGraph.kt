package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.auth.AuthNavGraph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.roles.RolesNavGraph

@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(
        navController= navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)

    }
}