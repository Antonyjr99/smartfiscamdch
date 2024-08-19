package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.mapper

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.update.AdminAsociacionUpdateState

fun AdminAsociacionUpdateState.toCategory():Asociacion{
    return Asociacion(
        name = name,
        description = description
    )
}