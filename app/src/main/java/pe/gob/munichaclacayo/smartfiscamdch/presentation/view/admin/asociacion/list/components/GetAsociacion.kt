package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.ProgressBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list.AdminAsociacionListViewModel

@Composable
fun GetCategories(navController: NavHostController ,paddingValues: PaddingValues, vm:AdminAsociacionListViewModel = hiltViewModel()) {

    when(val response = vm.categoriesResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Sucess -> {
            AdminCategoryListContent(navController, categories = response.data,paddingValues)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current,response.message,Toast.LENGTH_LONG).show()
        }
        else -> {
            if(response!= null){
                Toast.makeText(LocalContext.current,"Hubo error desconocido",Toast.LENGTH_LONG).show()
            }
        }
    }

}