package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.product

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.category.list.components.ClientCategoryListContent
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.product.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold {paddingValues ->
        ClientProductListContent(paddingValues = paddingValues)

    }
}