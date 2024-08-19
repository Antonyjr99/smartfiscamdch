package pe.gob.munichaclacayo.smartfiscamdch.domain.repository


import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String):  Resource<AuthResponse>
    suspend fun register(user: User):  Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}