package pe.gob.munichaclacayo.smartfiscamdch.domain.util


sealed class Resource<out T>{
    object Loading: Resource<Nothing>()
    data class Sucess<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val message:String): Resource<T>()
}