package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list.components.GetCategories


@Composable
fun AdminCategoryListScreen(navController: NavHostController){
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 70.dp),
                onClick = { navController.navigate(route = Graph.ADMIN_CATEGORY) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "d"
                )
            }
        },
        //modifier = Modifier.padding(16.dp)

    ) {paddingValues ->
        GetCategories(navController,paddingValues)
    }

}