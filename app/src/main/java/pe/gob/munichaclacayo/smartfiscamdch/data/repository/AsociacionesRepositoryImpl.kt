package pe.gob.munichaclacayo.smartfiscamdch.data.repository

import android.util.Log
import androidx.room.Entity
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AsociacionesLocalDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AsociacionesRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.mapper.toCategory
import pe.gob.munichaclacayo.smartfiscamdch.data.mapper.toCategoryEntity
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.ResponseToRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity.AsociacionEntity
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.isListEqual
import java.io.File

class AsociacionesRepositoryImpl(
    private val remoteDataSource: AsociacionesRemoteDataSource,
    private val localDataSource: AsociacionesLocalDataSource
):AsociacionesRepository {

    override suspend fun create(asociacion: Asociacion, file: File): Resource<Asociacion> =ResponseToRequest.send(
        ResponseToRequest.send(remoteDataSource.create(asociacion,file)).run {
            return when(this){
                is Resource.Sucess ->{
                    localDataSource.create(this.data.toCategoryEntity())
                    Resource.Sucess(this.data)
                }
                else ->{
                    Resource.Failure("Error Desconocido ")
                }
            }
        }
    )

    override fun getCategories(): Flow<Resource<List<Asociacion>>> = flow {

        localDataSource.getCategories().collect(){
            it.run{
                val asociacionesLocalMap = this.map { asociacionEntity -> asociacionEntity.toCategory() }
                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when(this){
                            is Resource.Sucess ->{
                                val asociacionesRemote = this.data


                                if (!isListEqual(asociacionesRemote,asociacionesLocalMap)){
                                    localDataSource.inserAll(asociacionesRemote.map { category -> category.toCategoryEntity() })
                                }
                                emit(Resource.Sucess(asociacionesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Sucess(asociacionesLocalMap))
                            }
                            else-> {
                                emit(Resource.Sucess(asociacionesLocalMap))
                            }
                        }
                    }
                }catch (e:Exception){
                    emit(Resource.Sucess(asociacionesLocalMap))
                }



            }
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun update(id: String, asociacion: Asociacion): Resource<Asociacion> {
        ResponseToRequest.send(remoteDataSource.update(id,asociacion)).run {
            return when(this){
                is Resource.Sucess ->{
                    localDataSource.update(
                        id=this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?:""
                    )
                    Resource.Sucess(this.data)
                }
                else ->{
                    Resource.Failure("Error Desconocido ")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        asociacion: Asociacion,
        file: File
    ): Resource<Asociacion> = ResponseToRequest.send(
        ResponseToRequest.send(remoteDataSource.updateWithImage(id,asociacion,file)).run {
            return when(this){
                is Resource.Sucess ->{
                    localDataSource.update(
                        id=this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?:""
                    )
                    Resource.Sucess(this.data)
                }
                else ->{
                    Resource.Failure("Error Desconocido ")
                }
            }
        }
    )

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }


}