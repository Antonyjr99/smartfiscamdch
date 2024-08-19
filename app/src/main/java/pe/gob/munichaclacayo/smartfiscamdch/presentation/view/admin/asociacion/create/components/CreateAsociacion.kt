package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.components


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.ProgressBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.AdminAsociacionCreateViewModel

@Composable
fun CreateAsociacion(vm: AdminAsociacionCreateViewModel = hiltViewModel()){
    when(val response = vm.asociacionResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Sucess -> {
            vm.clearForm()
            Toast.makeText(LocalContext.current,"Se a creado correctamente la asociacion",Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current,response.message,Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null){
                Toast.makeText(LocalContext.current,"Hubo error desconocido",Toast.LENGTH_LONG).show()
            }
        }

    }
}