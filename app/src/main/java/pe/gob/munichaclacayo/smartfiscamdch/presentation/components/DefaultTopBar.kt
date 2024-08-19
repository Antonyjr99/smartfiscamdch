package pe.gob.munichaclacayo.smartfiscamdch.presentation.components

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvaileble:Boolean=false,
    navController:NavHostController? = null
){
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        navigationIcon = {
            if(upAvaileble){
                IconButton(onClick = {navController?.popBackStack()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )

                }
            }

        }
    )
}