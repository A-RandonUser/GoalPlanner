package com.example.mygoalplanner

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.mygoalplanner.data.DummyGoals
import com.example.mygoalplanner.data.Goal
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterialApi::class)
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
                                navController.navigate(Screen.AddScreen.route + "/0L")

                                }
                                    )
                {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }

            }

             ){

        val goalList = viewModel.getAllGoals.collectAsState(initial = listOf())
        LazyColumn( modifier = Modifier
            .fillMaxSize()
            .padding(it) )
        {
            items(goalList.value, key= {goal -> goal.id}){
                goal ->
                val dismissState = rememberDismissState(
                    confirmStateChange = {
                        if (it == DismissValue.DismissedToEnd || it ==DismissValue.DismissedToStart)
                        {
                            viewModel.deleteGoal(goal)
                        }
                        true
                    }
                )

                SwipeToDismiss(
                    state = dismissState,
                    background ={
                       val color by animateColorAsState(
                           if(dismissState.dismissDirection==DismissDirection.EndToStart)
                           Color.Cyan else Color.Transparent ,
                           label = ""
                       )
                        val alignment = Alignment.CenterEnd
                        Box(
                            Modifier.fillMaxSize().background(color).padding(horizontal = 16.dp),
                            contentAlignment = alignment
                        ){
                            Icon(Icons.Default.Delete, contentDescription = "Delete icon", tint = Color.White)
                        }
                                } ,
                    directions = setOf(DismissDirection.EndToStart),
                    dismissThresholds = {FractionalThreshold(0.25f)},
                    dismissContent =
                    {
                        GoalItem(goal = goal) {
                            val id = goal.id
                            navController.navigate(Screen.AddScreen.route + "/$id")
                                               }

                    }
                             )






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