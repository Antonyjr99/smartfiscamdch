package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.datastore.AuthDatastore
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import kotlinx.coroutines.flow.Flow


class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore):
    AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}