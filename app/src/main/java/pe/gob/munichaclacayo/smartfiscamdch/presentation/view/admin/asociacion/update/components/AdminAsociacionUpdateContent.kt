package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import pe.gob.munichaclacayo.smartfiscamdch.R
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultButton
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTextField
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.AdminAsociacionUpdateViewModel
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.components.DialogCapturePicture


@Composable
fun AdminCategoryUpdateContent(paddingValues: PaddingValues,vm:AdminAsociacionUpdateViewModel = hiltViewModel()){
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember {
        mutableStateOf(false)
    }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        if (!state.image.isNullOrBlank()) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                model = state.image,
                contentDescription = ""
            )
        }
        else {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                painter = painterResource(id = R.drawable.image_add),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            //backgroundColor = Color.White
        ) {

            Column(
                modifier = Modifier.padding(30.dp)
            ) {

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { vm.onNameInput(it) },
                    label = "Nombre de la Asociacion",
                    icon = Icons.Default.List
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = { vm.onDescriptionInput(it)},
                    label = "Descripcion",
                    icon = Icons.Outlined.Info
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Actualizar Asociacion",
                    onClick = { vm.onUpdate() }
                )
            }

        }

    }
}