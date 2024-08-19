package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login.LoginContent

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.ProgressBar
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    when (val response = vm.loginResponse) {
        Resource.Loading -> { ProgressBar() }

        is Resource.Sucess -> { // Cambié "Sucess" a "Success"
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)

                // Normaliza el nombre del rol para evitar problemas con mayúsculas o espacios
                val roles = response.data.user?.roles?.map { it.name.trim().lowercase() }

                when {
                    roles?.contains("cliente") == true -> {
                        navController.navigate(route = Graph.CLIENT) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    }
                    roles?.contains("administrador") == true -> {
                        navController.navigate(route = Graph.ADMIN) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    }
                    else -> {
                        // Si no hay un rol específico, navega a una ruta predeterminada
                        navController.navigate(route = Graph.CLIENT) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    }
                }
            }
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

