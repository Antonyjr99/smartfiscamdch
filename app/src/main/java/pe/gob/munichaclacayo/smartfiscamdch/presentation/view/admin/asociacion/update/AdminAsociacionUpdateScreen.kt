package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTopBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.ui.theme.Gray200
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.components.AdminCategoryUpdateContent
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.components.UpdateCategory

@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController,categoryParam: String){

    Log.d("AdminCategoryUpdateScreen","Data: ${categoryParam}")

    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Actualizar Asociacion",
                upAvaileble = true,
                navController = navController
            )
        },
        containerColor  = Gray200
    ){ paddinValues ->
        AdminCategoryUpdateContent(paddingValues = paddinValues)
    }

    UpdateCategory()
}