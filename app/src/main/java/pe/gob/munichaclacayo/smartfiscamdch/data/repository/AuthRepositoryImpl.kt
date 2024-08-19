package pe.gob.munichaclacayo.smartfiscamdch.data.repository

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AuthLocalDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AuthRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
):AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> =ResponseToRequest.send(
        authRemoteDataSource.login(email,password)
    )


    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )
    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)
    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun logout() = authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()
}