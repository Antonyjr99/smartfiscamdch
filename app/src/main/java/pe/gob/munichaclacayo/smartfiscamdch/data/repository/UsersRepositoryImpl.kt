package pe.gob.munichaclacayo.smartfiscamdch.data.repository

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.UsersRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.UsersRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File) = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )

}