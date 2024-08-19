package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pe.gob.munichaclacayo.smartfiscamdch.presentation.ui.theme.EcommerceAppMVVMTheme
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login.LoginContent.Login
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login.LoginContent.LoginContent

@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(

    ) {paddingValues ->
        LoginContent(navController=navController, paddingValues)

    }

    Login(navController = navController)
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    EcommerceAppMVVMTheme {
        LoginScreen(rememberNavController() )

    }
}