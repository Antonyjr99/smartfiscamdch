package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.AsociacionesUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.presentation.util.ComposeFileProvider
import pe.gob.munichaclacayo.smartfiscamdch.presentation.util.ResultingActivityHandler
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.mapper.toCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminAsociacionUpdateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val categoriesUserCase:AsociacionesUseCase,
    @ApplicationContext val context: Context
):ViewModel() {
    var state by mutableStateOf(AdminAsociacionUpdateState())
        private set

    var asociacionResponse by mutableStateOf<Resource<Asociacion>?>(null)

    var file:File? = null

    val resultingActivityHandler = ResultingActivityHandler()

    var data = savedStateHandle.get<String>("category")
    val asociacion = Asociacion.fromJson(data!!)

    init {
        state = state.copy(
            name = asociacion.name,
            image = asociacion.image!!,
            description = asociacion.description,
            )
    }

    fun onUpdate(){
        if(file != null){
            updateCategoryWithImage()
        }
        else{
            updateCategory()
        }
    }

    fun updateCategory() = viewModelScope.launch {
            asociacionResponse = Resource.Loading
            val result = categoriesUserCase.updateCategory(asociacion.id?:"",state.toCategory())
            asociacionResponse = result

    }

    fun updateCategoryWithImage() = viewModelScope.launch {
        asociacionResponse = Resource.Loading
        val result = categoriesUserCase.updateCategoryWithImage(asociacion.id?:"",state.toCategory(),file!!)
        asociacionResponse = result

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

    fun onNameInput (input: String){
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String){
        state = state.copy(description = input)
    }



}