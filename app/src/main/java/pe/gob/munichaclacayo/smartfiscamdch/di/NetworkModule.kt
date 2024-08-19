package pe.gob.munichaclacayo.smartfiscamdch.di

import pe.gob.munichaclacayo.smartfiscamdch.core.Config
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.datastore.AuthDatastore
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.AuthService
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.AsociacionesService
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //usuarios

    @Provides
    @Singleton
    fun provideOkHttpClient(datastore: AuthDatastore) = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            datastore.getData().first().token
        }
        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit { // POSTMAN - THUNDER CLIENT - RETROFIT
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return  retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    //Categorias
    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): AsociacionesService {
        return retrofit.create(AsociacionesService::class.java)
    }
}