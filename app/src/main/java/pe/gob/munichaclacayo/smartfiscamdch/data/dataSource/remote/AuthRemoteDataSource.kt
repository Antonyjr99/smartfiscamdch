package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import retrofit2.Response


interface AuthRemoteDataSource {

    suspend fun login(email:String,password:String): Response<AuthResponse>

    suspend fun register(user:User): Response<AuthResponse>
}