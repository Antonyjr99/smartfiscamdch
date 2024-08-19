package pe.gob.munichaclacayo.smartfiscamdch.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList: AdminScreen(
        route = "admin/category/list",
        title = "Asociaciones",
        icon = Icons.Default.List
    )

    object ProductList: AdminScreen(
        route = "admin/product/list",
        title = "Motos",
        icon = Icons.Default.List
    )

    object Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}