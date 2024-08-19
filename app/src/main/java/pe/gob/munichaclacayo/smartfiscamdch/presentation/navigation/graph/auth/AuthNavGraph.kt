package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.auth.AuthScreen

import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login.LoginScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register.RegisterSreen


fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterSreen(navController)
        }


    }
}