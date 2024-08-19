package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.AuthService
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun  login(email: String,password:String) = authService.login(email,password)
    override suspend fun register(user: User): Response<AuthResponse>  = authService.register(user)

}
