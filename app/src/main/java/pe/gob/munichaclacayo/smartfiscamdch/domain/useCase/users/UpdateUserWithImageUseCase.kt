package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.users

import pe.gob.munichaclacayo.smartfiscamdch.domain.model.User
import pe.gob.munichaclacayo.smartfiscamdch.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}
