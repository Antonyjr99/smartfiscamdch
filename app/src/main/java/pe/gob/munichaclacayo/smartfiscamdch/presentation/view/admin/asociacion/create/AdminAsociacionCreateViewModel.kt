package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.AsociacionesUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.presentation.util.ComposeFileProvider
import pe.gob.munichaclacayo.smartfiscamdch.presentation.util.ResultingActivityHandler
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.mapper.toCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminAsociacionCreateViewModel @Inject constructor(
    private val categoriesUserCase:AsociacionesUseCase,
    @ApplicationContext val context: Context
):ViewModel() {
    var state by mutableStateOf(AdminAsociacionCreateState())
        private set

    var asociacionResponse by mutableStateOf<Resource<Asociacion>?>(null)

    var file:File? = null

    val resultingActivityHandler = ResultingActivityHandler()

    fun createCategory() = viewModelScope.launch {
        if (file !=null) {
            asociacionResponse = Resource.Loading
            val result = categoriesUserCase.createCategory(state.toCategory(), file!!)
            asociacionResponse = result
        }
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if(result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if(result != null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context,result))
            file = File(state.image)
        }
    }

    fun clearForm(){
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )

        asociacionResponse= null
    }

    fun onNameInput (input: String){
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String){
        state = state.copy(description = input)
    }



}