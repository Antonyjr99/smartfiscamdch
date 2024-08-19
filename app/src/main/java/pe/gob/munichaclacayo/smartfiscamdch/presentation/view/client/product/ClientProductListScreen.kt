package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.product

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTopBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.product.list.components.AdminProductListContent
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.product.list.components.sampleAsociaciones
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.product.components.ClientProductListContent

@Composable
fun ClientProductListScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de Mototaxis",
                navController = navController
            )
        },
    ) { paddingValues ->
        AdminProductListContent(
            asociaciones = sampleAsociaciones,
            paddingValues = paddingValues
        )
    }
}