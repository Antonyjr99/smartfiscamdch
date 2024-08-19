package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.product.list.components.AdminProductListContent


@Composable
fun AdminProductListScreen(){
    Scaffold {paddingValues ->
        AdminProductListContent(paddingValues = paddingValues)

    }
}