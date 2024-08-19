package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.Asociacion.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion

@Composable
fun ClientCategoryListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    asociaciones: List<Asociacion>
    ){
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = asociaciones,
        ){asociacion ->
            ClientAsociacionListItem(
                navController = navController,
                asociacion = asociacion)
        }
    }
}