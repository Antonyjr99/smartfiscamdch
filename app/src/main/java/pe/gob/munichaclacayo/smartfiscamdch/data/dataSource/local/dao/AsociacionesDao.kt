package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity.AsociacionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AsociacionesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(asociaciones: AsociacionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(asociaciones: List<AsociacionEntity>)

    @Query("SELECT * FROM asociaciones")
    fun getCategories(): Flow<List<AsociacionEntity>>

    @Query("UPDATE asociaciones SET name= :name,description = :description,image = :image WHERE id = :id")
    suspend fun update(id: String, name: String, description: String, image: String)

    @Query("DELETE FROM asociaciones WHERE id = :id")
    suspend fun delete(id: String)

}