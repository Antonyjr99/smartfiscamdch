package pe.gob.munichaclacayo.smartfiscamdch.di

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AuthRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AsociacionesRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.UsersRemoteDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.UsersRemoteDataSourceImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AuthRemoteDataSourceImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.AsociacionesRemoteDataSourceImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.AuthService
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.AsociacionesService
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun providesUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource =
        UsersRemoteDataSourceImpl(usersService )

    @Provides
    fun provideCategoriesRemoteDataSource(asociacionesService: AsociacionesService): AsociacionesRemoteDataSource =
        AsociacionesRemoteDataSourceImpl(asociacionesService)
}