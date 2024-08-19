package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import retrofit2.Response
import java.io.File

interface AsociacionesRemoteDataSource {

    suspend fun create(asociacion: Asociacion, file: File):Response<Asociacion>
    suspend fun getCategories(): Response<List<Asociacion>>
    suspend fun update(id:String, asociacion: Asociacion):Response<Asociacion>
    suspend fun updateWithImage(id:String, asociacion: Asociacion, file:File):Response<Asociacion>
    suspend fun delete(id: String):Response<Unit>
}