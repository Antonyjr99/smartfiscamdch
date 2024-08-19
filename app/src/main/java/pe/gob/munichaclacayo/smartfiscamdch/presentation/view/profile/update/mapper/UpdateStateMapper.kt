package pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.mapper

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.presentation.view.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image,
    )
}