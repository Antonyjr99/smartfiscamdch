package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTopBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.components.ProfileUpdateContent
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String) {

    Log.d("ProfileUpdateScreen", "Data: $userParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvaileble = true
            )
        }
    ) {paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
    UpdateUser()

}