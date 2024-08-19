package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("asociaciones")
data class AsociacionEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "image") var image: String = "",
)
