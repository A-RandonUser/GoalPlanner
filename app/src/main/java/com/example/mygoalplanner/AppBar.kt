package com.example.mygoalplanner

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
//padding start is left

@Composable
fun AppBarView(
    tittle:String ,
    onBackNavClicked:() -> Unit = {}
){
    //its a composable with no input or output nullable that will be an icon button for now

    val navigationIcon : (@Composable () -> Unit)? =

            if(!tittle.contains("GoalsToAchieve")){
                {
                IconButton(onClick = { onBackNavClicked() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = null
                    )
                                                             }
            }
            }else{
                null
            }






    TopAppBar(title = { Text(text = tittle, color = colorResource(id = R.color.white),
       modifier = Modifier
           .padding(start = 4.dp)
           .heightIn(max = 24.dp))
    } ,
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = navigationIcon
    )
}