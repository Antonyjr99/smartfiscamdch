package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}