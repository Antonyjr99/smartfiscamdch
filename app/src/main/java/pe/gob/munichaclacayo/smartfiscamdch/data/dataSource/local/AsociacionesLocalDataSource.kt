package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity.AsociacionEntity
import kotlinx.coroutines.flow.Flow

interface AsociacionesLocalDataSource {

    suspend fun create(asociacion: AsociacionEntity)
    suspend fun inserAll(asociaciones:List<AsociacionEntity>)
    fun getCategories():Flow<List<AsociacionEntity>>
    suspend fun update(id: String,name: String,description:String,image: String)
    suspend fun delete(id: String)
}