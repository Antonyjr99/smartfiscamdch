package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.roles

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.AuthUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(private  val authUseCase: AuthUseCase): ViewModel() {

    var authResponse by mutableStateOf(AuthResponse())

    init{
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){ data ->
            if(!data.token.isNullOrBlank()){
                authResponse = data
            }

        }
    }
}