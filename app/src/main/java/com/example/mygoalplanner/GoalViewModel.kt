package com.example.mygoalplanner

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GoalViewModel:ViewModel() {

    var goalTitleState by mutableStateOf("")
    var goalDescriptionState by mutableStateOf("")

    fun onGoalTitleChanged (newString:String){
        goalTitleState = newString
    }

    fun onGoalDescriptionChanged (newString:String){
        goalDescriptionState = newString
    }

}