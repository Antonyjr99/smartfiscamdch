package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.AsociacionesService
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class AsociacionesRemoteDataSourceImpl(private val asociacionesService: AsociacionesService):
    AsociacionesRemoteDataSource {

    override suspend fun create(asociacion: Asociacion, file: File): Response<Asociacion>{
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType
        val contentType ="text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file",file.name,requestFile)
        val nameData = asociacion.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = asociacion.description.toRequestBody(contentType.toMediaTypeOrNull())
        return asociacionesService.create(fileFormData,nameData,descriptionData)
    }

    override suspend fun getCategories(): Response<List<Asociacion>> = asociacionesService.getCategories()

    override suspend fun update(id: String, asociacion: Asociacion): Response<Asociacion> = asociacionesService.update(id,asociacion)

    override suspend fun updateWithImage(
        id: String,
        asociacion: Asociacion,
        file: File
    ): Response<Asociacion> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = asociacion.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = asociacion.description.toRequestBody(contentType.toMediaTypeOrNull())

        return asociacionesService.updateWithImage(fileFormData,id,nameData,descriptionData)
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}