package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth

import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke() =repository.getSessionData()
}