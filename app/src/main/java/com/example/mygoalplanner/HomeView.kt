package com.example.mygoalplanner

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.mygoalplanner.data.DummyGoals
import com.example.mygoalplanner.data.Goal

@Composable
fun HomeView(
    navController: NavController,
    viewModel: GoalViewModel
){
    val context = LocalContext.current
    val fabColor = Color(ContextCompat.getColor(context, R.color.app_bar_color))
    Scaffold (
        topBar = {AppBarView(tittle = "GoalsToAchieve", {
            Toast.makeText(context,"Button Clicked", Toast.LENGTH_LONG).show()
        })},
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.padding(all = 20.dp),
                    contentColor = Color.White,
                    backgroundColor =fabColor,
                    onClick = { Toast.makeText(context,"Floating Button Clicked", Toast.LENGTH_LONG).show()
                                navController.navigate(Screen.AddScreen.route)

                                }
                                    )
                {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }

            }

             ){
        LazyColumn( modifier = Modifier
            .fillMaxSize()
            .padding(it) )
        {
            items(DummyGoals.goalList){
                goal -> GoalItem(goal = goal) {
                
            }
            }
         }
    }
}

@Composable
fun GoalItem(goal:Goal , onClick:() -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable { onClick() },
        elevation = 10.dp,
        backgroundColor = Color.White
        )
    {
        Column (modifier = Modifier.padding((16.dp)))
        {
            Text(text = goal.title , fontWeight = FontWeight.ExtraBold)
            Text(text = goal.description)
        }
    }


}