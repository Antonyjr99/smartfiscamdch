package pe.gob.munichaclacayo.smartfiscamdch.domain.util

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun<T>send(result:Response<T>):Resource<T>{
        return try {
            if(result.isSuccessful){
                Resource.Sucess(result.body()!!)
            }
            else{
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error Desconocido")
            }

        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la peticion Http")
        }catch (e: IOException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Verifica tu conexion a internet")
        }catch (e: java.lang.Exception){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }
}