package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth

import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password:String) = repository.login(email,password)

}