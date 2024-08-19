package pe.gob.munichaclacayo.smartfiscamdch.domain.util

import android.util.Log
import pe.gob.munichaclacayo.smartfiscamdch.domain.model.ErrorResponse
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody

object ConvertErrorBody {
    fun convert(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it) // Convert the error body to JSON
            }
        } catch (e: Exception) {
            Log.d("ConvertErrorBody", "Error: " + e.message)
            null
        }
    }
}
