package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import kotlinx.coroutines.flow.Flow


interface AuthLocalDataSource {

    suspend fun  saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun  logout()
    fun getSessionData():Flow<AuthResponse>
}