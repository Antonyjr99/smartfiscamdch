package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.graph.admin.AdminNavGraph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold (
        bottomBar = { AdminBottomBar(navController = navController) }
    ){  paddingValues ->
        AdminNavGraph(navController = navController)
    }
}