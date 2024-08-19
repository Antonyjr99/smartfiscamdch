package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.login

import android.util.Log
import android.util.Patterns
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
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase):ViewModel(){
    var state by mutableStateOf(LoginState())
        private set


    var errorMessage by mutableStateOf("")

    init{
        getSessionData()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){data ->
            if(!data.token.isNullOrBlank() ){
                loginResponse=Resource.Sucess(data)
            }
        }
    }
    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    //Respuesta de login
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun login() = viewModelScope.launch {
        if(isValidForm()){
            loginResponse = Resource.Loading
            val result = authUseCase.login(state.email,state.password)
            loginResponse = result
            Log.d("LoginViewModel","Response:${loginResponse}")
        }


    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean{

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false
        }
        else if(state.password.length< 6 ){
            errorMessage = "La contraseña debe tener minimo 6 caracteres"
            return false
        }
        return true
    }

}