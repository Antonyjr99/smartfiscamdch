package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.category.list.components.ClientCategoryListContent
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.info.components.ProfileContent

@Composable
fun ClientCategoryListScreen(){
    Scaffold {paddingValues ->
        ClientCategoryListContent(paddingValues = paddingValues)

    }
}