package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.ProgressBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register.RegisterViewModel

@Composable
fun Register(navcontroller:NavHostController,vm: RegisterViewModel = hiltViewModel()){

    when(val response = vm.registerResponse){
        Resource.Loading -> { ProgressBar()}
        is Resource.Sucess -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navcontroller.navigate(route = Graph.CLIENT){
                    popUpTo(Graph.AUTH){inclusive = true}
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null){
                Toast.makeText(LocalContext.current,"Error desconocido",Toast.LENGTH_SHORT).show()
            }
        }
    }

}