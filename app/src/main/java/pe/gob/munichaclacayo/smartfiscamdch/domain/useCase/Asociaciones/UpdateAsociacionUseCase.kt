package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository

class UpdateAsociacionUseCase(private val repository: AsociacionesRepository) {
    suspend operator fun invoke(id:String, asociacion:Asociacion)=repository.update(id,asociacion)
}