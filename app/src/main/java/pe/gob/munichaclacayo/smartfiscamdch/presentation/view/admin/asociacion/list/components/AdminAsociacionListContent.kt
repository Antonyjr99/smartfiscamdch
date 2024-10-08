package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion

@Composable
fun AdminCategoryListContent(navController: NavHostController, categories: List<Asociacion>, paddingValues: PaddingValues){

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 70.dp)
    ) {
        items(
            items = categories
        ){category ->
            AdminCategoryListItem(navController,category)

        }

    }
}