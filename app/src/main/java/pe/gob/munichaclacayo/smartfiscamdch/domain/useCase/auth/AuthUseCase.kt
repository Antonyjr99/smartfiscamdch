package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register:RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout:LogoutUseCase,
    val updateSession: UpdateSessionUseCase
)