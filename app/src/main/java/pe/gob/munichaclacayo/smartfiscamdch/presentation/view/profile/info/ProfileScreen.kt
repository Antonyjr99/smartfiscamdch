package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.info.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController){
    Scaffold { paddingValues ->
        ProfileContent(
            paddingValues = paddingValues,
            navController = navController
        )
    }
}
