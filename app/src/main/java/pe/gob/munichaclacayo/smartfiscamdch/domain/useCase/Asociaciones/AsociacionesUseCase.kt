package pe.gob.munichaclacayo.smartfiscamdch.domain.useCase.Asociaciones

data class AsociacionesUseCase(
    val createCategory: CreateAsociacionUseCase,
    val getCategories:GetAsociacionesUseCase,
    val updateCategory: UpdateAsociacionUseCase,
    val updateCategoryWithImage: UpdateAsociacionWithImageUseCase
)
