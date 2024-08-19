package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository

data class RegisterUseCase(private val repository: AuthRepository){
    suspend operator fun invoke(user:User) = repository.register(user)
}
