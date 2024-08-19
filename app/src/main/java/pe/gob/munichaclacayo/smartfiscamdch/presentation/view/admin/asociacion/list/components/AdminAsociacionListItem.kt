package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.R
import pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.admin.AdminCategoryScreen
import pe.gob.munichaclacayo.smartfiscamdch.presentation.ui.theme.blue200

@Composable
fun AdminCategoryListItem(navController: NavHostController, asociacion: Asociacion) {

    Card(
        modifier = Modifier.padding(bottom = 15.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        /*colors = CardDefaults.cardColors(
            containerColor = blue200
        )*/
    ){

        Column(
            Modifier
                .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                .height(90.dp)

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(), // Asegura que el Row ocupe todo el ancho
                horizontalArrangement = Arrangement.Center, // Centra los elementos horizontalmente
                verticalAlignment = Alignment.CenterVertically // Alinea verticalmente al centro
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    model = asociacion.image,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = asociacion.name,
                        color = Color.Gray,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = asociacion.description,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(27.dp)
                            .clickable {
                                navController.navigate(
                                    route = AdminCategoryScreen.CategoryUpdate.passCategory(asociacion.toJson())
                                )
                            },
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = ""
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                color = Color.LightGray,
                modifier = Modifier
                    .padding(top = 15.dp, start = 30.dp) // Usa padding para la indentación
                    .height(1.dp)
            )
        }
    }
}
