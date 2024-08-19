package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.AsociacionesUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminAsociacionListViewModel @Inject constructor(private val asociacionesUseCase: AsociacionesUseCase):ViewModel() {

    var categoriesResponse by mutableStateOf<Resource<List<Asociacion>>?>(null)

    init {
        getCategories()
    }

    fun getCategories ()= viewModelScope.launch {
        categoriesResponse =Resource.Loading
        asociacionesUseCase.getCategories().collect(){ data ->
            categoriesResponse = data

        }
    }

}