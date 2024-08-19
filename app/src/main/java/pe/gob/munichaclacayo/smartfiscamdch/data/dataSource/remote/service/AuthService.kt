package pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.AuthResponse
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun  login(
        @Field("email") email:String,
        @Field("password") password:String
    ):Response<AuthResponse>

    @POST("auth/register")
    suspend fun  register(
        @Body() user:User,
    ):Response<AuthResponse>
}