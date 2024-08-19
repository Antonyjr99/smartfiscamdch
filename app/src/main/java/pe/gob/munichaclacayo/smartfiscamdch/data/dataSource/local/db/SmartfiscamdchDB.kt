package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.dao.AsociacionesDao
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity.AsociacionEntity

@Database(
    entities = [AsociacionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SmartfiscamdchDB:RoomDatabase() {
    abstract fun categoriesDao():AsociacionesDao
}