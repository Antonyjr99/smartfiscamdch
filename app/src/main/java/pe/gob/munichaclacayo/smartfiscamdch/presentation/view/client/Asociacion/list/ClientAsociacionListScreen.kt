package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.Asociacion.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.Asociacion.list.components.GetCategories


@Composable
fun ClientCategoryListScreen(navController: NavHostController){
    Scaffold (
    ){ paddingValues ->
        GetCategories( navController,paddingValues )
    }
}