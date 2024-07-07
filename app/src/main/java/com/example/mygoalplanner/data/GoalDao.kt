package com.example.mygoalplanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GoalDao {
    //in case you add the same item twice we ignore the second insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAGoal(goalEntity:Goal)

    //Loads all goals from the goal table
    @Query("Select * from `goal-table`")
    abstract  fun getAllGoals(): Flow<List<Goal>>

    @Update
    abstract suspend fun updateAGoal(goalEntity:Goal)

    @Delete
    abstract suspend fun deleteAGoal(goalEntity:Goal)

    @Query("Select * from `goal-table` where id=:id ")
    abstract  fun getAGoalById(id:Long): Flow<List<Goal>>
}