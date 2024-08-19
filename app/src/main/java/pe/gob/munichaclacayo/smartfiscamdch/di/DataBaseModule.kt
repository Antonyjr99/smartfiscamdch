package pe.gob.munichaclacayo.smartfiscamdch.di

import android.app.Application
import androidx.room.Room
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.dao.AsociacionesDao
import pe.gob.munichaclacayo.smartfiscamdch.data.dataSource.local.db.SmartfiscamdchDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(app:Application): SmartfiscamdchDB =
        Room.databaseBuilder(app,SmartfiscamdchDB::class.java,"smartfiscamdch_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCategoriesDao(db: SmartfiscamdchDB): AsociacionesDao = db.categoriesDao()
}