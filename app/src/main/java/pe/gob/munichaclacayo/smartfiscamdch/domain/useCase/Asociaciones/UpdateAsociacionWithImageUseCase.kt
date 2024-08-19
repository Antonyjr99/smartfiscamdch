package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository
import java.io.File

class UpdateAsociacionWithImageUseCase(private val repository: AsociacionesRepository) {
    suspend operator fun invoke(id:String, asociacion:Asociacion, file:File)=repository.updateWithImage(id,asociacion,file)
}