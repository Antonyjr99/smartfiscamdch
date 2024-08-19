package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.Asociacion.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.presentation.ui.theme.blue200

@Composable
fun ClientAsociacionListItem(navController: NavHostController,asociacion: Asociacion){
    Card(
        modifier = Modifier.padding(bottom = 15.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = blue200
            )
        ){
            Column {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    model = asociacion.image,
                    contentDescription ="",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    text = asociacion.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                    )
                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                    text = asociacion.description,
                    fontSize = 14.sp,
                    //fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
}