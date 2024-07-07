package com.example.mygoalplanner

import android.content.Context
import androidx.room.Room
import com.example.mygoalplanner.data.GoalDatabase
import com.example.mygoalplanner.data.GoalRepository

object Graph {
    //object graph declares a singleton called graph there
    // will be only 1 instance of this graph in the app
    //by lazy makes sure the variable is initialized only when its needed
    //the repository will be loaded only when its required instead of in the begining of the app


    lateinit var database:GoalDatabase
    val goalRepository by lazy {
        GoalRepository(goalDao = database.goalDao())
    }

    //here we innitialize the database with this function
    fun provide (context:Context){
        database = Room.databaseBuilder(context,GoalDatabase::class.java ,"goalList.db").build()
    }

}