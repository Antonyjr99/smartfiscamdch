package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.users

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.UsersRepository

class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}