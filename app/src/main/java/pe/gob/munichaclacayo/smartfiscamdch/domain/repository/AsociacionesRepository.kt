package pe.gob.munichaclacayo.smartfiscamdch.domain.repository

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface AsociacionesRepository {
    suspend fun create(asociacion: Asociacion, file:File):Resource<Asociacion>
    fun getCategories():Flow<Resource<List<Asociacion>>>
    suspend fun update(id:String, asociacion: Asociacion):Resource<Asociacion>
    suspend fun updateWithImage(id: String, asociacion: Asociacion, file:File):Resource<Asociacion>
    suspend fun delete(id:String):Resource<Unit>
}