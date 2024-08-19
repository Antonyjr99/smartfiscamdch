package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.client.Asociacion.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.AsociacionesUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import javax.inject.Inject

@HiltViewModel
class ClientAsociacionListViewModel @Inject constructor(private val asociacionesUseCase:AsociacionesUseCase): ViewModel() {

    var asociacionResponse by mutableStateOf<Resource<List<Asociacion>>?>(null)

    init {
        getAsociaciones()
    }

    fun getAsociaciones() = viewModelScope.launch {
        asociacionResponse = Resource.Loading
        asociacionesUseCase.getCategories().collect(){
            asociacionResponse = it
        }
    }

}