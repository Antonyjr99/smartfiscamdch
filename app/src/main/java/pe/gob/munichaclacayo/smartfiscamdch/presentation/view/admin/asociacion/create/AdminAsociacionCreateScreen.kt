package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTopBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.ui.theme.Gray200
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.components.AdminCategoryCreateContent
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.components.CreateAsociacion


@Composable
fun AdminCategoryCreateScreen(navController: NavHostController){
    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Nueva Asociacion",
                upAvaileble = true,
                navController = navController
            )
        },
        containerColor  = Gray200
    ){ paddinValues ->
        AdminCategoryCreateContent(paddingValues = paddinValues)
    }

    CreateAsociacion()
}