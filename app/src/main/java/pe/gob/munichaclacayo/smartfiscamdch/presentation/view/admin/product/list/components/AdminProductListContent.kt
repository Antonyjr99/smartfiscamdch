package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.product.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // ¡IMPORTANTE!
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
import coil.compose.AsyncImage
import pe.gob.munichaclacayo.smartfiscamdch.R

data class Asociacion(
    val image: String,
    val name: String,
    val description: String
)

val sampleAsociaciones = listOf(
    Asociacion(
        image = "https://via.placeholder.com/150",
        name = "5419-IC",
        description = "Bajaj"
    ),
    Asociacion(
        image = "https://via.placeholder.com/150",
        name = "C1-5473",
        description = "Bajaj"
    )
    // Agrega más asociaciones si es necesario
)

@Composable
fun AdminProductListContent(asociaciones: List<Asociacion>, paddingValues: PaddingValues) {
    LazyColumn(contentPadding = paddingValues) {
        items(asociaciones) { asociacion -> // Aquí es donde items es necesario
            Card(
                modifier = Modifier.padding(bottom = 15.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(4.dp),
            ) {
                Column(
                    Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                        .height(90.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            model = asociacion.image, // Aquí se referencia asociacion.image correctamente
                            contentDescription = null
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
                                    .size(27.dp),
                                painter = painterResource(id = R.drawable.edit),
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(top = 15.dp, start = 30.dp)
                            .height(1.dp)
                    )
                }
            }
        }
    }
}
