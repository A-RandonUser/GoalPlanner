package com.example.mygoalplanner.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [Goal::class],
    version = 1,
    exportSchema = false
)
abstract class GoalDatabase :RoomDatabase(){
    abstract fun goalDao():GoalDao
}