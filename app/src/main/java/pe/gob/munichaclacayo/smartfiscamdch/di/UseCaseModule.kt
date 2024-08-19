package pe.gob.munichaclacayo.smartfiscamdch.di

import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AuthRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.AsociacionesRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.UsersRepository
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.AuthUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.GetSessionDataUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.LoginUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.LogoutUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.RegisterUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.SaveSessionUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth.UpdateSessionUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.AsociacionesUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.CreateAsociacionUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.GetAsociacionesUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.UpdateAsociacionUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones.UpdateAsociacionWithImageUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.users.UpdateUserUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.users.UpdateUserWithImageUseCase
import pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository)= AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(asociacionesRepository: AsociacionesRepository)= AsociacionesUseCase(
        createCategory = CreateAsociacionUseCase(asociacionesRepository),
        getCategories = GetAsociacionesUseCase(asociacionesRepository),
        updateCategory = UpdateAsociacionUseCase(asociacionesRepository),
        updateCategoryWithImage = UpdateAsociacionWithImageUseCase(asociacionesRepository )
    )
}