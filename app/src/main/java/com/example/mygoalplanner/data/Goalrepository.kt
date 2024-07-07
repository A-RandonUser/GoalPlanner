package com.example.mygoalplanner.data

import kotlinx.coroutines.flow.Flow

class Goalrepository(private val goalDao:GoalDao) {

    suspend fun addAGoal(goal:Goal){
        goalDao.addAGoal(goal)
    }

    fun getGoals():Flow<List<Goal>> = goalDao.getAllGoals()

    fun getAGoalById(id:Long): Flow<List<Goal>> {
        return goalDao.getAGoalById(id)
    }

    suspend fun updateAGoal(goal: Goal){
        goalDao.updateAGoal(goal)
    }

    suspend fun deleteAWish(goal: Goal){
        goalDao.deleteAGoal(goal)
    }

}