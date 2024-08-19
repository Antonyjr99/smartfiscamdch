package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import pe.gob.munichaclacayo.smartfiscamdch.R
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultButton
import pe.gob.munichaclacayo.smartfiscamdch.presentation.components.DefaultTextField
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.ProfileUpdateViewModel

@Composable
fun ProfileUpdateContent(paddingValues: PaddingValues, vm: ProfileUpdateViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    val state = vm.state
    val stateDialog = remember { mutableStateOf(false) }
    vm.resultingActivityHandler.handle()

    // Custom dialog to capture or select a picture
    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )

    Box(modifier = Modifier
        .padding(paddingValues)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(40.dp))
            if (!state.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .clickable { stateDialog.value = true },
                    model = state.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .clickable { stateDialog.value = true },
                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.7f))
            ) {
                Column(modifier = Modifier.padding(30.dp)) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "ACTUALIZAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = { vm.onNameInput(it) },
                        label = "Nombre",
                        icon = Icons.Default.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastname,
                        onValueChange = { vm.onLastnameInput(it) },
                        label = "Apellido",
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = { vm.onPhoneInput(it) },
                        label = "Telefono",
                        icon = Icons.Default.Phone
                    )

                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Confirmar",
                        onClick = { vm.onUpdate() }
                    )
                }
            }
        }
    }
}

@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit
) {
    if (state.value) {
        AlertDialog(
            onDismissRequest = { state.value = false },
            title = { Text(text = "Capture Picture") },
            text = {
                Column {
                    TextButton(onClick = {
                        takePhoto()
                        state.value = false  // Cierra el diálogo después de tomar la foto
                    }) {
                        Text(text = "Take Photo")
                    }
                    TextButton(onClick = {
                        pickImage()
                        state.value = false  // Cierra el diálogo después de seleccionar la imagen
                    }) {
                        Text(text = "Pick from Gallery")
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { state.value = false }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}

