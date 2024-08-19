package pe.gob.munichaclacayo.smartfiscamdch.di

import pe.gob.munichaclacayo.smartfiscamdch.data.repository.AuthRepositoryImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.repository.UsersRepositoryImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AuthLocalDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AsociacionesLocalDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AuthRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AsociacionesRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.UsersRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.repository.AsociacionesRepositoryImpl
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object  RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource,authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoriesRepository(
        asociacionesRemoteDataSource: AsociacionesRemoteDataSource,
        asociacionesLocalDataSource: AsociacionesLocalDataSource
    ):AsociacionesRepository = AsociacionesRepositoryImpl(asociacionesRemoteDataSource,asociacionesLocalDataSource)
}
