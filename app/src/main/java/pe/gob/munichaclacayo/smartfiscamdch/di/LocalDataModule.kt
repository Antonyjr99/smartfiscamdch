package pe.gob.munichaclacayo.smartfiscamdch.di

import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.datastore.AuthDatastore
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AuthLocalDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AuthLocalDataSourceImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AsociacionesLocalDataSource
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.AsociacionesLocalDataSourceImpl
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.dao.AsociacionesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDatao: AsociacionesDao):AsociacionesLocalDataSource = AsociacionesLocalDataSourceImpl(categoriesDatao)
}