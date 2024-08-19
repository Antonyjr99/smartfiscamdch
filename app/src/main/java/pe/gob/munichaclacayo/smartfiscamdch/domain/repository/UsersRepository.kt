package pe.gob.munichaclacayo.smartfiscamdch.domain.repository

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>

}