package com.example.mygoalplanner


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController

@Composable
fun AddEditDetailView (
        id:Long ,
        viewModel : GoalViewModel,
        navController: NavController
){
    val context = LocalContext.current
    val btnBackGroundColor = Color(ContextCompat.getColor(context, R.color.app_bar_color))

    Scaffold (
        topBar = { AppBarView(tittle =
            if(id != 0L) {  stringResource(id = R.string.update_goal)}
            else {stringResource(id = R.string.add_goal)}
                              )
            {navController.navigateUp()}
                 }
             )
    {


        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Spacer(modifier = Modifier.height(10.dp))
            
            GoalTextField(label = "Title", value = viewModel.goalTitleState,
                onValueChanged = {viewModel.onGoalTitleChanged(it)}
            )

            Spacer(modifier = Modifier.height(10.dp))

            GoalTextField(label = "Description", value = viewModel.goalDescriptionState,
                onValueChanged = {viewModel.onGoalDescriptionChanged(it)}
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if(viewModel.goalTitleState.isNotEmpty() && viewModel.goalDescriptionState.isNotEmpty())
                {
                    //TODO Update goal
                }else{
                    //TODO add Wish
                }
                             },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = btnBackGroundColor
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(16.dp)
                )


            {
                Text(text = if(id != 0L){stringResource(id = R.string.update_goal)}
                            else {stringResource(id = R.string.add_goal)},
                             style = TextStyle(fontSize = 18.sp)
                    )
            }
        }
    }
}


@Composable
fun GoalTextField(
    label:String,
    value:String,
    onValueChanged: (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label, color = Color.Black)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //using predefined color
            textColor =  Color.Black,
            //using our own colors in res.values.colors
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
        )

    )
}

@Preview
@Composable
fun GoalTestFieldPrev(){
    GoalTextField(label = "text", value = "text", onValueChanged = {})
}