package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones

import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository

class GetAsociacionesUseCase (private val repository: AsociacionesRepository){
    suspend operator fun invoke()=repository.getCategories()
}