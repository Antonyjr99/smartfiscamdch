package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTopBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){
        Scaffold(
            topBar = { DefaultTopBar(title = "Selecciona un Rol")}
        ) { paddingValues ->
            RolesContent(paddingValues, navController )
        }
}