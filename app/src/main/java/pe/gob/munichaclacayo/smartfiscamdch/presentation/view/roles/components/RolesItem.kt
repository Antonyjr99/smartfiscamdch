package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Rol
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.Graph

@Composable
fun RolesItem(rol:Rol,navController: NavHostController){
    Column (modifier = Modifier.clickable {
      navController.navigate(route = rol.route){
            popUpTo(route = Graph.ROLES){inclusive = true}
        }
    }){
        Spacer(modifier = Modifier.height(20.dp))

        AsyncImage(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            model = rol.image,

            contentDescription = "Placeholder Image"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = rol.name,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
    }

}