package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.AuthUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUserCase:AuthUseCase): ViewModel(){

    var state by mutableStateOf(RegisterState())
        private set

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    var errorMessage by mutableStateOf("")

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUserCase.saveSession(authResponse)
    }

    fun register()  = viewModelScope.launch {
        val user = User(
            name = state.name,
            lastname = state.lastname,
            phone = state.phone,
            email = state.email,
            password = state.password
            )
        registerResponse = Resource.Loading
        val result = authUserCase.register(user)
        registerResponse = result
    }

    fun onNameInput(input:String){
        state = state.copy(name = input)
    }

    fun onLastNameInput(input:String){
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input:String){
        state = state.copy(email = input)
    }


    fun onPhoneInput(input:String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input:String){
        state = state.copy(confirmPassword = input)
    }

    fun isValidForm():Boolean{
        if (state.name == "") {
            errorMessage = "Ingrese su Nombre"
            return false
        }else if(state.lastname == ""){
            errorMessage = "Ingresar sus Apellidos"
            return false
        }else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }else if(state.phone==""){
            errorMessage="Ingrese su numero de celular"
            return false
        }else if(state.phone.length<9 || state.phone.length>9 ){
            errorMessage="Ingrese un numero de celular valido"
            return false
        } else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener minimo 6 caracteres"
            return false
        }else if(state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
            return false
        }

        return true
    }
}