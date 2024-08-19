package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTopBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register.components.Register
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register.components.RegisterContent


@Composable
fun RegisterSreen(navController: NavHostController){
    Scaffold(
       topBar = {
           DefaultTopBar(
               title = "Registro",
               upAvaileble = true,
               navController=navController
           )

       }
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
}