package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.dao.AsociacionesDao
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity.AsociacionEntity
import kotlinx.coroutines.flow.Flow

class AsociacionesLocalDataSourceImpl(private  val asociacionesDao: AsociacionesDao):AsociacionesLocalDataSource {
    override suspend fun create(asociacion: AsociacionEntity) = asociacionesDao.insert(asociacion)

    override suspend fun inserAll(asociaciones: List<AsociacionEntity>) = asociacionesDao.insertAll(asociaciones)

    override fun getCategories(): Flow<List<AsociacionEntity>> = asociacionesDao.getCategories()

    override suspend fun update(id: String, name: String, description: String, image: String) =
        asociacionesDao.update(id,name,description,image)

    override suspend fun delete(id: String) = asociacionesDao.delete(id)
}