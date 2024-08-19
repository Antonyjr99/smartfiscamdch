package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository
import java.io.File

class CreateAsociacionUseCase(private val repository: AsociacionesRepository) {
    suspend operator fun invoke(asociacion: Asociacion, file: File)= repository.create(asociacion,file)
}