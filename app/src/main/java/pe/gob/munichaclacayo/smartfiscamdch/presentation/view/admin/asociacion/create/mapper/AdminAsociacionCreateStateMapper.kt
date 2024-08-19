package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.mapper

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.Asociacion
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.admin.asociacion.create.AdminAsociacionCreateState

fun AdminAsociacionCreateState.toCategory():Asociacion{
    return Asociacion(
        name = name,
        description = description
    )
}