package pe.gob.munichaclacayo.smartfiscamdch.data.mapper

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.entity.AsociacionEntity
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion

fun AsociacionEntity.toCategory():Asociacion{
    return Asociacion(
        id = id,
        name = name,
        description =description,
        image = image
    )
}

fun Asociacion.toCategoryEntity():AsociacionEntity{
    return AsociacionEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}