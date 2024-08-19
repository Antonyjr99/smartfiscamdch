package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.client.ClientNavGraph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold (
        bottomBar = { ClientBottomBar(navController = navController)}
    ){  paddingValues ->
        ClientNavGraph(navController = navController)
    }
}