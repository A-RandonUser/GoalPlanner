package com.example.mygoalplanner

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygoalplanner.data.Goal
import com.example.mygoalplanner.data.GoalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GoalViewModel(
    private val goalRepository: GoalRepository = Graph.goalRepository
):ViewModel() {

    var goalTitleState by mutableStateOf("")
    var goalDescriptionState by mutableStateOf("")

    fun onGoalTitleChanged (newString:String){
        goalTitleState = newString
    }

    fun onGoalDescriptionChanged (newString:String){
        goalDescriptionState = newString
    }

    lateinit var getAllGoals: Flow<List<Goal>>
    //the var will be initialized before we call any operations on it

    init {
        viewModelScope.launch {
            getAllGoals = goalRepository.getGoals()
        }
    }

    fun addGoal(goal: Goal){
        viewModelScope.launch(Dispatchers.IO) {
            goalRepository.addAGoal(goal = goal)
        }
    }
    //dispatcherio maintains a shared pool of threads that can grow or shrink according to demands
    //we ensure that the system resaurces are used efficiently
    fun updateGoal(goal: Goal){
        viewModelScope.launch(Dispatchers.IO) {
            goalRepository.updateAGoal(goal = goal)
        }
    }

    fun getAGoalById(id:Long): Flow<Goal>
    {
         return goalRepository.getAGoalById(id)
    }

    fun deleteGoal(goal: Goal){
        viewModelScope.launch (Dispatchers.IO){
            goalRepository.deleteAWish(goal = goal)
        }
    }

}